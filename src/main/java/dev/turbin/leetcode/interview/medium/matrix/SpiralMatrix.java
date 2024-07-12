package dev.turbin.leetcode.interview.medium.matrix;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
@SpringBootTest
public class SpiralMatrix {

    @Test
    void test1() {
        assertThat(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}))
                .isEqualTo(List.of(1,2,3,4,8,12,11,10,9,5,6,7));
    }


    @Test
    void test2() {
        assertThat(spiralOrder(new int[][]{{1,2,}}))
                .isEqualTo(List.of(1,2));
    }@Test
    void test3() {
        assertThat(spiralOrder(new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13}}))
                .isEqualTo(List.of(2,3,4,7,10,13,12,11,8,5,6,9));
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        if (matrix.length == 1) {
            for (int n :
                    matrix[0]) {
                list.add(n);
            }
            return list;
        }

        if (matrix[0].length == 1) {
            for (int[] n :
                    matrix) {
                list.add(n[0]);
            }
            return list;
        }

        if (matrix.length == 2) {
            for (int n :
                    matrix[0]) {
                list.add(n);
            }
            for (int i = matrix[1].length-1; i >= 0 ; i--) {
                list.add(matrix[1][i]);
            }
            return list;
        }

        int j = 0;
        int i = 0;

        for (int k = 0; k < matrix.length/2; k++) {
            while (j < matrix[0].length - k) {
                list.add(matrix[i][j]);
                j++;
            }
            j--;
            i++;
            while (i < matrix.length - k) {
                list.add(matrix[i][j]);
                i++;
            }

            i--;
            j--;

            while (j > k) {
                list.add(matrix[i][j]);
                j--;
            }

            while (i > k) {
                list.add(matrix[i][j]);
                i--;
            }

            j++;
            i++;
        }

        return list;
    }
}
