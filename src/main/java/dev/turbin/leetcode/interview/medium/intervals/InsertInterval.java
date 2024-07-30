package dev.turbin.leetcode.interview.medium.intervals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 */
public class InsertInterval {

    @Test
    void test1() {
        assertThat(insert(new int[][]{{1,3},{6,9}}, new int[]{2,5})).isEqualTo(new int[][]{{1,5},{6,9}});
    }

    @Test
    void test2() {
        assertThat(insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8})).isEqualTo(new int[][]{{1,2},{3,10},{12,16}});
    }

    @Test
    void test3() {
        assertThat(insert(new int[][]{{1,5}}, new int[]{2,3})).isEqualTo(new int[][]{{1,5}});
    }

    @Test
    void test4() {
        assertThat(insert(new int[][]{{1,5}}, new int[]{6,8})).isEqualTo(new int[][]{{1,5}, {6,8}});
    }

    @Test
    void test5() {
        assertThat(insert(new int[][]{{1,5},{9,12}}, new int[]{6,8})).isEqualTo(new int[][]{{1,5}, {6,8}, {9,12}});
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }

        LinkedList<int[]> merged = new LinkedList<>();
        boolean flag = false;

        for (int[] interval : intervals) {
            if (newInterval[1] < interval[0]) {
                if (merged.isEmpty() || merged.peekLast()[1] < newInterval[0]) {
                    merged.add(newInterval);
                    flag = true;
                }
                merged.add(interval);
            } else if (interval[0] <= newInterval[0] && interval[1] >= newInterval[1]) {
                merged.add(interval);
                flag = true;
            } else if (newInterval[0] > interval[1]) {
                merged.add(interval);
            } else if (!merged.isEmpty() && merged.peekLast()[1] >= interval[0]) {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            } else if (newInterval[0] >= interval[0] || newInterval[1] <= interval[1]) {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
                merged.add(newInterval);
                flag = true;
            }
        }

        if (!flag) {
            merged.add(newInterval);
        }

        return merged.toArray(new int[merged.size()][]);
    }

    //Better
    public int[][] insertLeetCodeSolution(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i=0;
        int n=intervals.length;
        while(i<n && intervals[i][1]<newInterval[0]){//left portion
            res.add(intervals[i]);
            i=i+1;
        }
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i=i+1;
        }
        res.add(newInterval);
        while(i<n){
            res.add(intervals[i]);
            i=i+1;
        }
        return res.toArray(new int[res.size()][]);
    }


}
