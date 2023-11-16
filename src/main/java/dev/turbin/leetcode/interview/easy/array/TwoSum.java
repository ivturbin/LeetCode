package dev.turbin.leetcode.interview.easy.array;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
@SpringBootTest
public class TwoSum {
    @Test
    void test1() {
        int[] nums = {2,7,11,15};
        int target = 9;

        assertThat(twoSum(nums, target)).isEqualTo(new  int[]{0,1});
    }

    @Test
    void test2() {
        int[] nums = {3,3};
        int target = 6;

        assertThat(twoSum(nums, target)).isEqualTo(new  int[]{0,1});
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length+1, 1);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            Integer temp = map.get(target-nums[i]);
            if (temp != null && temp != i) {
                result[0] = i;
                result[1] = temp;
                break;
            }
        }

        return result;
    }
}
