package dev.turbin.leetcode.interview.medium.intervals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MinimumNumberOfArrowsToBurstBalloons {

    @Test
    void test1() {
        assertThat(findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}})).isEqualTo(4);
    }

    @Test
    void test2() {
        assertThat(findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}})).isEqualTo(2);
    }

    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        Arrays.sort(points,(a, b)->Integer.compare(a[1],b[1]));
        int end=points[0][1];
        int count=1;
        for(int i=1;i<points.length;i++){
            if(points[i][0]>end){
                count++;
                end=points[i][1];
            }
        }
        return count;
    }
}
