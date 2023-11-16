package dev.turbin.leetcode.interview.easy.strings;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
@SpringBootTest
public class ReverseString {

    @Test
    void test1() {
        char[] s = new char[]{'h','e','l','l','o'};

        reverseString(s);

        assertThat(s).isEqualTo(new char[]{'o','l','l','e','h'});
    }

    public void reverseString(char[] s) {
        char buf;
        for (int i = 0, j = s.length-1; i < s.length/2; i++, j--) {
            buf = s[j];
            s[j] = s[i];
            s[i] = buf;
        }
    }
}
