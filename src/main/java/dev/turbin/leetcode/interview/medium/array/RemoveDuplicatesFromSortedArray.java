package dev.turbin.leetcode.interview.medium.array;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice.
 * The relative order of the elements should be kept the same.
 */
@SpringBootTest
public class RemoveDuplicatesFromSortedArray {
    @Test
    void test1() {
        assertThat(removeDuplicates(new int[]{1,1,1,2,2,3}))
                .isEqualTo(5);
    }

    @Test
    void test2() {
        assertThat(removeDuplicates(new int[]{1,1,1}))
                .isEqualTo(2);
    }

    @Test
    void test3() {
        assertThat(removeDuplicates(new int[]{1,1,1,2,2,2,3,3}))
                .isEqualTo(6);
    }

    public int removeDuplicates(int[] nums) {
        int length = nums.length;

        int count = 1;
        int i = 1;
        for (; i < length; i++) {

            if (nums[i] == nums[i-1]) {
                count++;
            } else {
                if (count > 2) {
                    for (int j = i; j < length; j++) {
                        nums[j - (count-2)] = nums[j];
                    }
                    length -= count-2;
                    i -= count-2;
                }

                count = 1;
            }

        }

        if (count > 2) {
            for (int j = i; j < length; j++) {
                nums[j - (count-2)] = nums[j];
            }
            length -= count-2;
        }

        return  length;
    }
}
