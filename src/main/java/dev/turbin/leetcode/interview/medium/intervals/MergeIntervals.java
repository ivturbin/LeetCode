package dev.turbin.leetcode.interview.medium.intervals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given an array of intervals where intervals[i] = [starti, endi].
 * Merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeIntervals {
    @Test
    void test1() {
        assertThat(merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})).isEqualTo(new int[][]{{1,6},{8,10},{15,18}});
    }

    @Test
    void test2() {
        assertThat(merge(new int[][]{{1,4},{0,0}})).isEqualTo(new int[][]{{1,4},{0,0}});
    }


    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
