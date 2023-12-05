package dev.turbin.leetcode.interview.easy.strings;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 */
@SpringBootTest
public class ImplementStrStr {

    @Test
    void test1() {
        String haystack = "sadbutsad", needle = "sad";

        assertThat(strStr(haystack, needle)).isEqualTo(0);
    }

    @Test
    void test2() {
        String haystack = "leetcode", needle = "leeto";

        assertThat(strStr(haystack, needle)).isEqualTo(-1);
    }


    public int strStr(String haystack, String needle) {



        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            while (j < needle.length()) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }

        return haystack.indexOf(needle);
    }
}

