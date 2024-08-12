package dev.turbin.leetcode.interview.easy.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given an integer array nums and an integer k,
 * return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */
public class ContainsDuplicateII {

    @Test
    void test1() {
        assertThat(containsNearbyDuplicate(new int[]{1,2,3,1}, 3))
                .isEqualTo(true);
    }

    @Test
    void test2() {
        assertThat(containsNearbyDuplicate(new int[]{1,0,1,1}, 1))
                .isEqualTo(true);
    }

    @Test
    void test3() {
        assertThat(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2))
                .isEqualTo(false);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            Integer i1 = map.get(nums[i]);
            if (i1 == null) {
                map.put(nums[i], i);
            } else {
                if (Math.abs(i1 - i) <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }

        }
        return false;
    }
}
