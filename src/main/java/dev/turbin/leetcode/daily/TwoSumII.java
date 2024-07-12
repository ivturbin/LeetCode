package dev.turbin.leetcode.daily;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 */
@SpringBootTest
public class TwoSumII {

    @Test
    void test1() {
        assertThat(twoSum(new int[]{2, 7, 11, 15}, 9))
                .isEqualTo(new int[]{1, 2});
    }

    @Test
    void test2() {
        assertThat(twoSum(new int[]{2,3,4}, 6))
                .isEqualTo(new int[]{1, 3});
    }

    @Test
    void test3() {
        assertThat(twoSum(new int[]{-1,0}, -1))
                .isEqualTo(new int[]{1, 2});
    }

    public int[] twoSum(int[] numbers, int target) {

        int i = 0;
        int j = numbers.length-1;
        while (true) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[] {i+1, j+1};
            }
        }
    }
}
