package dev.turbin.leetcode.daily;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line
 * in non-decreasing order by height. Let this ordering be represented by the integer array expected
 * where expected[i] is the expected height of the ith student in line.
 */
@SpringBootTest
public class HeightChecker {

    @Test
    void test1() {
        assertThat(heightChecker(new int[]{1,1,4,2,1,3}))
                .isEqualTo(3);
    }

    public int heightChecker(int[] heights) {

        int[] ints = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);

        int count = 0;

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != ints[i]) {
                count++;
            }
        }
        return count;

    }
}
