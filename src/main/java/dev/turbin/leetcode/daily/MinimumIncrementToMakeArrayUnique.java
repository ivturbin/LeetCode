package dev.turbin.leetcode.daily;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.
 * Return the minimum number of moves to make every value in nums unique.
 */
@SpringBootTest
public class MinimumIncrementToMakeArrayUnique {

    @Test
    void test1() {
        assertThat(minIncrementForUnique(new int[]{3,2,1,2,1,7}))
                .isEqualTo(6);
    }

    public int minIncrementForUnique(int[] nums) {

        Arrays.sort(nums);
        int count = 0;

        for (int i = 1; i < nums.length; ) {

            if (nums[i] <= nums[i-1]) {
                nums[i]++;
                count++;
            } else {
                i++;
            }
        }

        return count;
    }
}
