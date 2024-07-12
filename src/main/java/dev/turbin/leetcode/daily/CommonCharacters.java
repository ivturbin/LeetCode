package dev.turbin.leetcode.daily;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * You are given two strings s and t consisting of only lowercase English letters.
 * Return the minimum number of characters that need to be appended to the end of s so that t becomes a subsequence of s.
 */
@SpringBootTest
public class CommonCharacters {
    @Test
    void test1() {
        assertThat(commonChars(new String[]{"bella", "label", "roller"})).containsAll(Arrays.asList("e","l","l"));
    }

    public List<String> commonChars(String[] words) {

        byte[] chars = new byte[27];

        for (byte i = 0; i < 27; i++) {

            byte minOccurs = 100;
            for (byte j = 0; j < words.length; j++) {
                byte count2 = containsChar(words[j], (char) ((byte) 'a' + i));
                if (count2 == 0) {
                    minOccurs = 0;
                    break;
                } else {
                    minOccurs = count2 < minOccurs ? count2 : minOccurs;
                }
            }

            chars[i] = minOccurs;
        }

        List<String> result = new ArrayList<>(100);

        for (byte i = 0; i < 27; i++) {
            for (byte j = 0; j < chars[i]; j++) {
                result.add(String.valueOf((char)((byte) 'a' + i)));
            }
        }

        return result;
    }

    byte containsChar(String str, char ch) {
        byte res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                res++;
            }
        }
        return res;
    }

}
