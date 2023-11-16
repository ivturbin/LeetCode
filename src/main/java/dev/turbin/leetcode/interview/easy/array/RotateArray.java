package dev.turbin.leetcode.interview.easy.array;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 */

@SpringBootTest
public class RotateArray {

    @Test
    void test1() {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        rotate(nums, k);

        assertThat(nums).isEqualTo(new int[]{5, 6, 7, 1, 2, 3, 4});
    }

    @Test
    void test2() {
        int[] nums = {-1, -100, 3, 99};
        int k = 2;

        rotate(nums, k);

        assertThat(nums).isEqualTo(new int[]{3,99,-1,-100});
    }

    @Test
    void test3() {
        int[] nums = {-1};
        int k = 1;

        rotate(nums, k);

        assertThat(nums).isEqualTo(new int[]{-1});
    }

    @Test
    void test4() {
        int[] nums = {1, 2};
        int k = 2;

        rotate(nums, k);

        assertThat(nums).isEqualTo(new int[]{1, 2});
    }

    @Test
    void test5() {
        int[] nums = {1, 2, 3};
        int k = 2;

        rotate(nums, k);

        assertThat(nums).isEqualTo(new int[]{2, 3, 1});
    }

    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if (nums.length == 1 || k == 0) {
            return;
        }
        int[] buf = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            buf[(i+k)%nums.length] = nums[i];
        }

        System.arraycopy(buf, 0, nums, 0, nums.length);
    }
}
