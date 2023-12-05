package dev.turbin.leetcode.interview.easy.strings;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 * The algorithm for myAtoi(string s) is as follows:
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 */
@SpringBootTest
public class StringToInteger {

    @Test
    void test1() {
        String s = "    -42";

        assertThat(myAtoi(s)).isEqualTo(-42);
    }

    @Test
    void test2() {
        String s = "+1";

        assertThat(myAtoi(s)).isEqualTo(1);
    }

    @Test
    void test3() {
        String s = " ";

        assertThat(myAtoi(s)).isEqualTo(0);
    }

    @Test
    void test4() {
        String s = "9223372036854775808";

        assertThat(myAtoi(s)).isEqualTo(2147483647);
    }

    public int myAtoi(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i == s.length()) {
            return 0;
        }

        long result = 0;
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            result *= 10;
            result += Character.getNumericValue(s.charAt(i));
            i++;
            if (result*sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result*sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) result*sign;
    }
}
