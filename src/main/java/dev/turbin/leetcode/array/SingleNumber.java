package dev.turbin.leetcode.array;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
@SpringBootTest
public class SingleNumber {

    @Test
    void test1() {
        int[] nums = {2,2,1};

        assertThat(singleNumber(nums)).isEqualTo(1);
    }

    @Test
    void test2() {
        int[] nums = {4,1,2,1,2};

        assertThat(singleNumber(nums)).isEqualTo(4);
    }

    public int singleNumber(int[] nums) {

        HashSet<Integer> set = new HashSet<>(nums.length/2, 1);

        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }

        return (int) set.toArray()[0];
    }
}
