package dev.turbin.leetcode.daily;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
 * A subarray is a contiguous part of an array.
 */
@SpringBootTest
public class SubarrayDivisibleSums {

    @Test
    void test1() {
        assertThat(subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5))
                .isEqualTo(7);
    }

    public int subarraysDivByK(int[] nums, int k) {
        int prefixMod = 0;
        int count = 0;
        HashMap<Integer, Integer> modSeen = new HashMap<>();
        modSeen.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixMod = (prefixMod + nums[i]) % k;

            if (modSeen.containsKey(prefixMod)) {
                count++;
            } else {
                // mark the value of prefixMod with the current index.
                modSeen.put(prefixMod, i);
            }
        }

        return count;
    }

    //Too slow
    public int subarraysDivByK1(int[] nums, int k) {


        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
