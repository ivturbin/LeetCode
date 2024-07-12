package dev.turbin.leetcode.interview.easy.twoits;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 */
@SpringBootTest
public class IsSubsequence {

    @Test
    void test1() {
        assertThat(isSubsequence("abc", "ahbgdc"))
                .isEqualTo(true);
    }

    @Test
    void test2() {
        assertThat(isSubsequence("", "ahbgdc"))
                .isEqualTo(true);
    }

    public boolean isSubsequence(String s, String t) {

        if (s.isEmpty()) {
            return true;
        }

        if (t.isEmpty()) {
            return false;
        }

        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;

                if (i == s.length()) {
                    return true;
                }
            }
        }

        return false;

    }
}
