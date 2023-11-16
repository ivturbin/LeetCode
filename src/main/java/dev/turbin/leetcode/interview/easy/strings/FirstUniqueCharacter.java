package dev.turbin.leetcode.interview.easy.strings;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 */

/**
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 *
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 */

@SpringBootTest
public class FirstUniqueCharacter {

    @Test
    void test1() {
        String s = "leetcode";

        assertThat(firstUniqChar(s)).isEqualTo(0);
    }

    @Test
    void test2() {
        String s = "loveleetcode";

        assertThat(firstUniqChar(s)).isEqualTo(2);
    }

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
            } else {
                map.put(s.charAt(i), i);
            }
        }

        return map.values().stream()
                .filter(v -> v != -1)
                .sorted()
                .findFirst()
                .orElse(-1);
    }
}
