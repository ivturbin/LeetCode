package dev.turbin.leetcode.interview.easy.strings;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
@SpringBootTest
public class ValidAnagram {

    @Test
    void test1() {
        String s = "anagram";
        String t = "nagaram";

        assertThat(isAnagram(s, t)).isEqualTo(true);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            if (map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), map1.get(s.charAt(i))+1);
            } else {
                map1.put(s.charAt(i), 1);
            }
        }

        Integer count;

        for (int i = 0; i < t.length(); i++) {
            count = map1.get(t.charAt(i));
            if (count == null) {
                return false;
            }
            if (count == 1) {
                map1.remove(t.charAt(i));
            } else {
                map1.put(t.charAt(i), count-1);
            }
        }

        return map1.values().isEmpty();
    }
}
