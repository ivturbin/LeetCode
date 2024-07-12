package dev.turbin.leetcode.daily;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 */
@SpringBootTest
public class SortColors {

    @Test
    void test1() {

        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        assertThat(nums)
                .isEqualTo(new int[]{0, 0, 1, 1, 2, 2});
    }


    @Test
    void test2() {

        int[] nums = {1};
        sortColors(nums);
        assertThat(nums)
                .isEqualTo(new int[]{1});
    }

    public void sortColors(int[] nums) {

        short[] counts = new short[3];
        short i = 0, j = 0;

        for (; i < nums.length; i++) {
            counts[nums[i]]++;
        }

        i = 0;

        while (i < nums.length) {

            if (counts[j] == 0) {
                j++;
                continue;
            }

            nums[i] = j;
            counts[j]--;
            i++;

        }

    }
}
