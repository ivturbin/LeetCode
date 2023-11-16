package dev.turbin.leetcode.interview.easy.array;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 */
@SpringBootTest
public class MoveZeroes {
    @Test
    void test1() {
        int[] nums = {0,1,0,3,12};

        moveZeroes(nums);

        assertThat(nums).isEqualTo(new  int[]{1,3,12,0,0});
    }

    @Test
    void test2() {
        int[] nums = {0};

        moveZeroes(nums);

        assertThat(nums).isEqualTo(new  int[]{0});
    }
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
