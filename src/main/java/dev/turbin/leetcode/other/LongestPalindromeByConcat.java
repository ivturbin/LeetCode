package dev.turbin.leetcode.other;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * You are given an array of strings words. Each element of words consists of two lowercase English letters.
 * Create the longest possible palindrome by selecting some elements from words and concatenating them in any order.
 * Each element can be selected at most once.
 */
@SpringBootTest
public class LongestPalindromeByConcat {
    @Test
    void test1() {
        assertThat(longestPalindrome(new String[]{"lc","cl","gg"})).isEqualTo(6);
    }

    @Test
    void test2() {
        assertThat(longestPalindrome(new String[]{"ab","ty","yt","lc","cl","ab"})).isEqualTo(8);
    }
    @Test
    void test3() {
        assertThat(longestPalindrome(new String[]{"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"})).isEqualTo(22);
    }
    public int longestPalindrome(String[] words) {

        int[] indices = new int[words.length];
        boolean singlePalindrome = false;

        for (int i = 0; i < words.length; i++) {

            for (int j = i+1; j < words.length; j++) {
                if (indices[i] == 0 && indices[j] == 0 && words[i].charAt(0) == words[j].charAt(1) && words[i].charAt(1) == words[j].charAt(0)) {
                    indices[i]++;
                    indices[j]++;
                    break;
                }
            }

            if (!singlePalindrome && indices[i] == 0 && words[i].charAt(0) == words[i].charAt(1)) {
                singlePalindrome = true;
                indices[i]++;
            }
        }

        int count = 0;
        for (int i = 0; i < indices.length; i++) {
            count += indices[i]*2;
        }
        return count;
    }

}
