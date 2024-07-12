package dev.turbin.leetcode.interview.medium.sliding_window;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 */
@SpringBootTest
public class MinimumSizeSubarraySum {
    @Test
    void test1() {
        assertThat(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}))
                .isEqualTo(2);
    }

    @Test
    void test2() {
        assertThat(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}))
                .isEqualTo(0);
    }

    @Test
    void test3() {
        assertThat(minSubArrayLen(11, new int[]{1,2,3,4,5}))
                .isEqualTo(3);
    }

    public int minSubArrayLen(int target, int[] nums) {

        int i = 0, j = 0, result = 0, sum = 0;

        while (sum < target && j < nums.length) {
            sum += nums[j];
            j++;
        }

        if (sum < target) {
            return result;
        }

        result = j-i;
        sum -= nums[i++];

        while (true) {
            if (sum >= target) {
                result--;
                sum -= nums[i++];
            } else if (j < nums.length) {
                sum -= nums[i++];
                sum += nums[j++];
            } else {
                break;
            }
        }

        return result;

    }
}
