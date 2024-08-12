package dev.turbin.leetcode.interview.easy.map;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 */
public class HappyNumber {

    @Test
    void test1() {
        assertThat(isHappy(19))
                .isEqualTo(true);
    }

    @Test
    void test2() {
        assertThat(isHappy(2))
                .isEqualTo(false);
    }

    public boolean isHappy(int n) {

        int count = 0;
        while (n != 1 && count < 1000) {
            n = getNewNumber(n);
            count++;
        }


        return count != 1000;
    }

    private int getNewNumber(int n) {
        int result = 0;

        while (n != 0) {
            result += (n%10)*(n%10);
            n /= 10;
        }

        return result;
    }
}
