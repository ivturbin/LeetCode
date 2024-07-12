package dev.turbin.leetcode.interview.medium.map;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 */
public class LongestConsecutiveSequence {

    @Test
    void test1() {
        assertThat(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}))
                .isEqualTo(9);
    }

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int count = 1;
        int maxCount = 1;
        int buf = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (buf + 1 == nums[i]) {
                count++;

                if (count > maxCount) {
                    maxCount = count;
                }
            } else if (buf + 1 < nums[i]) {
                count = 1;
            }

            buf = nums[i];
        }

        return maxCount;
    }
}
