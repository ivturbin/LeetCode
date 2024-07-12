package dev.turbin.leetcode.daily;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * There are n seats and n students in a room. You are given an array seats of length n, where seats[i] is the position of the ith seat.
 * You are also given the array students of length n, where students[j] is the position of the jth student.
 */
@SpringBootTest
public class MinimumNumberOfMoves {

    @Test
    void test1() {
        assertThat(minMovesToSeat(new int[]{4,1,5,9}, new int[]{1,3,2,6}))
                .isEqualTo(7);
    }

    @Test
    void test2() {
        assertThat(minMovesToSeat(new int[]{12,14,19,19,12}, new int[]{19,2,17,20,7}))
                .isEqualTo(19);
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        int result = 0;

        Arrays.sort(seats);
        Arrays.sort(students);

        for (int i = 0; i < seats.length; i++) {
            result += seats[i] - students[i] > 0 ? seats[i] - students[i] : -(seats[i] - students[i]);
        }

        return result;
    }


}
