package dev.turbin.leetcode.interview.easy.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WordPattern {

    @Test
    void test1() {
        assertThat(wordPattern("abba", "dog cat cat dog")).isEqualTo(true);
    }

    @Test
    void test2() {
        assertThat(wordPattern("aaaa", "dog cat cat dog")).isEqualTo(false);
    }

    public boolean wordPattern(String pattern, String s) {

        String[] s1 = s.split(" ");

        if (pattern.length() != s1.length) {
            return false;
        }

        short[] patternIndex = new short[27];
        Map<String, Short> sIndex = new HashMap<>(30);

        for (int i = 0; i < pattern.length(); i++) {
            if (patternIndex[pattern.charAt(i)-'a'] != sIndex.getOrDefault(s1[i], (short) 0)) {
                return false;
            }



            patternIndex[pattern.charAt(i)-'a'] = (short) (i + 1);
            sIndex.put(s1[i], (short) (i+1));
        }


        return true;

    }
}
