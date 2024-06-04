package dev.turbin.leetcode.daily;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome
 * that can be built with those letters.
 */
@SpringBootTest
public class LongestPalindrome {


    @Test
    void test1() {
        assertThat(longestPalindrome("abccccdd")).isEqualTo(7);
    }

    @Test
    void test2() {
        assertThat(longestPalindrome("a")).isEqualTo(1);
    }

    public int longestPalindrome(String s) {
        short[] chars = new short[70];
        for (short i = 0; i < s.length(); i++) {
            chars[(short) s.charAt(i) - (short) 'A']++;
        }
        short count = 0;
        boolean flag = false;
        for (short i = 0; i < 70; i++) {
            if (chars[i] != 0) {
                count += (short) ((chars[i] / 2) * 2);
                if (chars[i] % 2 == 1) {
                    flag = true;
                }
            }
        }

        count += (short) (flag ? 1 : 0);

        return count;
    }
}
