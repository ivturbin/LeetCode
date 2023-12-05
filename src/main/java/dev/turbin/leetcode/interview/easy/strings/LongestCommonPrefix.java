package dev.turbin.leetcode.interview.easy.strings;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 */
@SpringBootTest
public class LongestCommonPrefix {

    @Test
    void test1() {
        String[] strs = {"flower","flow","flight"};

        assertThat(longestCommonPrefix(strs)).isEqualTo("fl");
    }

    @Test
    void test2() {
        String[] strs = {"ab", "a"};

        assertThat(longestCommonPrefix(strs)).isEqualTo("a");
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        int i = 0;
        while (true) {
            if (i == strs[0].length()) {
                return prefix.toString();
            }
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != ch) {
                    return prefix.toString();
                }
            }
            prefix.append(ch);
            i++;
        }
    }

}
