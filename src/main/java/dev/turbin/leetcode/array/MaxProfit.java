package dev.turbin.leetcode.array;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 */

@SpringBootTest
public class MaxProfit {

    @Test
    void test1() {
        int[] prices = {7,1,5,3,6,4};

        assertThat(maxProfit(prices)).isEqualTo(7);
    }

    @Test
    void test2() {
        int[] prices = {1,2,3,4,5};

        assertThat(maxProfit(prices)).isEqualTo(4);
    }

    @Test
    void test3() {
        int[] prices = {7,6,4,3,1};

        assertThat(maxProfit(prices)).isEqualTo(0);
    }

    public int maxProfit(int[] prices) {

        int win = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                win += prices[i] - prices[i-1];
            }
        }

        return win;
    }
}
