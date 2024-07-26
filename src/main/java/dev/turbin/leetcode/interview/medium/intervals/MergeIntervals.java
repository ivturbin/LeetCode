package dev.turbin.leetcode.interview.medium.intervals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        byte[] indexation = new byte[10000];

        for (int i = 0; i < intervals.length; i++) {
            for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                indexation[j]++;
            }
        }

        int count = 0;
        int[] interval = null;

        for (int i = 0; i < indexation.length; i++) {
            if (interval == null && indexation[i] != 0) {
                interval = new int[2];
                interval[0] = i;
            } else if (interval != null && indexation[i] == 0 && indexation[i-1] != 0) {
                interval[1] = i;
                intervals[count] = interval;
                count++;
                interval = null;
            }
        }

        return Arrays.copyOfRange(intervals, 0, count);
    }
}
