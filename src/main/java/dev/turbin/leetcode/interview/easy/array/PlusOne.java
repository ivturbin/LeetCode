package dev.turbin.leetcode.interview.easy.array;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 */
@SpringBootTest
public class PlusOne {

    @Test
    void test1() {
        int[] digits = {1,2,3};

        assertThat(plusOne(digits)).isEqualTo(new  int[]{1,2,4});
    }

    @Test
    void test2() {
        int[] digits = {9};

        assertThat(plusOne(digits)).isEqualTo(new  int[]{1,0});
    }

    @Test
    void test3() {
        int[] digits = {9,9};

        assertThat(plusOne(digits)).isEqualTo(new  int[]{1,0,0});
    }


    public int[] plusOne(int[] digits) {
        digits[digits.length-1] += 1;
        for (int i = digits.length-1; i > 0; i--) {
            if (digits[i] != 10) {
                return digits;
            } else {
                digits[i-1] += 1;
                digits[i] = 0;
            }
        }

        if (digits[0] == 10) {
            int [] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        } else {
            return digits;
        }
    }
}
