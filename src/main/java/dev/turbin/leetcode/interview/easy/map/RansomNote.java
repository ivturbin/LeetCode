package dev.turbin.leetcode.interview.easy.map;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 */
public class RansomNote {

    @Test
    void test1() {
        assertThat(canConstruct("aa", "xacaa")).isEqualTo(true);
    }

    @Test
    void test2() {
        assertThat(canConstruct("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")).isEqualTo(true);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        short[] letters = new short[30];

        for (short i = 0; i < magazine.length(); i++) {
            byte c = (byte) (magazine.charAt(i) - 'a');
            letters[c]++;
        }

        for (short i = 0; i < ransomNote.length(); i++) {
            byte c = (byte) (ransomNote.charAt(i) - 'a');
            if (letters[c] == 0) {
                return false;
            } else {
                letters[c]--;
            }
        }

        return true;
    }
}
