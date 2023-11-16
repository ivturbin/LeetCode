package dev.turbin.leetcode.interview.easy.array;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */
@SpringBootTest
public class RotateImage {
    @Test
    void test1() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        rotate(matrix);

        assertThat(matrix).isEqualTo(new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}});
    }

    @Test
    void test2() {
        int[][] matrix = {
                {5,  1,  9,  11},
                {2,  4,  8,  10},
                {13, 3,  6,  7},
                {15, 14, 12, 16}};

        rotate(matrix);

        assertThat(matrix).isEqualTo(new int[][]{
                {15, 13, 2,  5},
                {14, 3,  4,  1},
                {12, 6,  8,  9},
                {16, 7,  10, 11}});
    }

    public void rotate(int[][] matrix) {

        int buf1;
        int buf2;
        int m;
        int n;


        for (int i = 0; i < matrix.length/2; i++) {
            for (int j = i; j < matrix.length-1-i; j++) {

                m = i;
                n = j;
                buf1 = matrix[m][n];

                do {

                    buf2 = m;
                    m = n;
                    n = matrix.length - 1 - buf2;

                    buf2 = matrix[m][n];
                    matrix[m][n] = buf1;
                    buf1 = buf2;
                }
                while (m != i || n != j);
            }
        }
    }
}
