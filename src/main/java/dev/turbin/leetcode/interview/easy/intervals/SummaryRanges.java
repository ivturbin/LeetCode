package dev.turbin.leetcode.interview.easy.intervals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SummaryRanges {

    @Test
    void test1() {
        assertThat(summaryRanges(new int[]{0,1,2,4,5,7}))
                .isEqualTo(List.of("0->2","4->5","7"));
    }

    @Test
    void test2() {
        assertThat(summaryRanges(new int[]{0,2,3,4,6,8,9}))
                .isEqualTo(List.of("0","2->4","6","8->9"));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>(nums.length);

        if (nums.length == 0) {
            return list;
        }

        StringBuilder s = new StringBuilder();
        s.append(nums[0]);

        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i]-1 != nums[i-1]) {
                if (count > 0) {
                    s.append("->").append(nums[i - 1]);
                }
                list.add(s.toString());
                s.delete(0, s.length());
                s.append(nums[i]);
                count = 0;
            } else {
                count++;
            }
        }

        if (!s.isEmpty()) {
            if (count > 0) {
                s.append("->").append(nums[nums.length-1]);
            }
            list.add(s.toString());
        }

        return list;
    }
}
