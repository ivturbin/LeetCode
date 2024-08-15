package dev.turbin.leetcode.interview.easy.strings;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Для заданной строки найти длину наибольшей подстроки без
 * повторяющихся символов.
 * Например:
 * abcabcbbddee -> 3 (abc)
 */
public class YandexLengthOfLongestSubstring {

    @Test
    void test1() {
        assertThat(findLengthOfLongestSubstring("pabcwwkew")).isEqualTo(5);
    }

    @Test
    void test2() {
        assertThat(findLengthOfLongestSubstring("pabcwwkeqazwkeqazn")).isEqualTo(7);
    }

    @Test
    void test3() {
        assertThat(findLengthOfLongestSubstring("abcabcabc")).isEqualTo(3);
    }

    public int findLengthOfLongestSubstring(String s) {
        int i = 0, j = 0;

        int result = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                result = Math.max(result, set.size());
            } else {
                while (s.charAt(i) != s.charAt(j)) {
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
                j++;
            }
        }

        return result;
    }
}
