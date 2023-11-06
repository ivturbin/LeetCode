package dev.turbin.leetcode.array;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */

@SpringBootTest
public class ContainsDuplicate {



    @Test
    void test1() {
        int[] nums = {1,2,3,1};

        assertThat(containsDuplicate(nums)).isEqualTo(true);
    }

    @Test
    void test2() {
        int[] nums = new int[100000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        assertThat(containsDuplicate(nums)).isEqualTo(false);
    }

    public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }

        return false;

    }
}
