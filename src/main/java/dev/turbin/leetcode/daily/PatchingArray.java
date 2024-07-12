package dev.turbin.leetcode.daily;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given a sorted integer array nums and an integer n,
 * add/patch elements to the array such that any number in the range [1, n] inclusive can be formed by the sum of some elements in the array.
 */
//TODO: unsolved
@SpringBootTest
public class PatchingArray {

    @Test
    void test1() {
        assertThat(minPatches(new int[]{1,5,10}, 20))
                .isEqualTo(2);
    }

    public int minPatches(int[] nums, int n) {
        Set<Integer> sums = new HashSet<>();

        int sum = nums[0];
        sums.add(sum);

        for (int i = 1; i < nums.length+1; i++) {

            if (i%2 == 0) {
                sum += nums[nums.length - i];
                sums.add(sum);
                for (int k = nums.length - 1; k > 1; k--) {
                    sum -= nums[k];
                    sum += nums[k-i];
                    sums.add(sum);
                }
            } else {
                for (int k = 0; k < nums.length - i; k++) {
                    sum -= nums[k];
                    sum += nums[k+i];
                    sums.add(sum);
                }
            }

        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!sums.contains(i)) {
                result++;
                for (int j = i; j > 0; j--) {
                    if (sums.contains(j)) {
                        sums.add(i-j);
                    }
                }
            }
        }
        return  0;
    }


}
