package dev.turbin.leetcode.interview.easy.array;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
@SpringBootTest
public class ValidSudoku {

    @Test
    void test1() {
        char[][] board = {
                  {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        assertThat(isValidSudoku(board)).isEqualTo(true);
    }

    @Test
    void test2() {
        char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        assertThat(isValidSudoku(board)).isEqualTo(false);
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Character> row = new HashSet<>(board[0].length, 1);
        Set<Character> column = new HashSet<>(board[0].length, 1);
        Set<Character> group1 = new HashSet<>(board[0].length, 1);
        Set<Character> group2 = new HashSet<>(board[0].length, 1);
        Set<Character> group3 = new HashSet<>(board[0].length, 1);

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (!row.add(board[i][j])) {
                        return false;
                    }


                }

                if (board[j][i] != '.') {
                    if (!column.add(board[j][i])) {
                        return false;
                    }
                }


            }

            if (i % 3 == 0) {
                group1.clear();
                group2.clear();
                group3.clear();
            }

            for (int k = 0; k < 3; k++) {
                if (board[i][k]!= '.' && !group1.add(board[i][k])
                        || board[i][k+3]!= '.' && !group2.add(board[i][k+3])
                        || board[i][k+6]!= '.' && !group3.add(board[i][k+6])) {
                    return false;
                }
            }

            row.clear();
            column.clear();


        }

        return true;
    }
}
