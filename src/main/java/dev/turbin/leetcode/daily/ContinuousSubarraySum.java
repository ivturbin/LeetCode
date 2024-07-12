package dev.turbin.leetcode.daily;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
 * A good subarray is a subarray where:
 * its length is at least two, and
 * the sum of the elements of the subarray is a multiple of k.
 */
@SpringBootTest
public class ContinuousSubarraySum {

    @Test
    void test1() {
        assertThat(checkSubarraySum(new int[]{23,2,4,6,7}, 6))
                .isEqualTo(true);
    }

    @Test
    void test2() {
        assertThat(checkSubarraySum(new int[]{23,2,6,4,7}, 6))
                .isEqualTo(true);
    }

    @Test
    void test3() {
        assertThat(checkSubarraySum(new int[]{23,2,6,4,7}, 13))
                .isEqualTo(false);
    }

    @Test
    void test4() {
        assertThat(checkSubarraySum(new int[]{5,0,0,0}, 13))
                .isEqualTo(true);
    }

    //From Editorial.
    //Main idea is to store (prefixMod + nums[i]) % k in hashmap.
    // If we have the value then it means to return true
    // because if we have two prefixes with equal modulo then we have a subarray between them which is divisible by k
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixMod = 0;
        HashMap<Integer, Integer> modSeen = new HashMap<>();
        modSeen.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixMod = (prefixMod + nums[i]) % k;

            if (modSeen.containsKey(prefixMod)) {
                // ensures that the size of subarray is at least 2
                if (i - modSeen.get(prefixMod) > 1) {
                    return true;
                }
            } else {
                // mark the value of prefixMod with the current index.
                modSeen.put(prefixMod, i);
            }
        }

        return false;
    }


    //Too slow
    public boolean checkSubarraySum1(int[] nums, int k) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
