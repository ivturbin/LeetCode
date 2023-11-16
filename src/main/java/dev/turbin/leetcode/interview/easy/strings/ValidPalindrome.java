package dev.turbin.leetcode.interview.easy.strings;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
 * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
@SpringBootTest
public class ValidPalindrome {
    @Test
    void test1() {
        String s = "A man, a plan, a canal: Panama";

        assertThat(isPalindrome(s)).isEqualTo(true);
    }

    @Test
    void test2() {
        String s = "a.1   ";

        assertThat(isPalindrome(s)).isEqualTo(false);
    }

    @Test
    void test3() {
        String s = ".a";

        assertThat(isPalindrome(s)).isEqualTo(true);
    }

    @Test
    void test4() {
        String s = ".,";

        assertThat(isPalindrome(s)).isEqualTo(true);
    }

    public boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }

        int i = 0, j = s.length()-1;

        while (true) {
            while (i <= s.length()-1 && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (i > j) {
                return true;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
    }
}
