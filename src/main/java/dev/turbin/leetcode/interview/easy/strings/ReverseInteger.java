package dev.turbin.leetcode.interview.easy.strings;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
 */
@SpringBootTest
public class ReverseInteger {

    @Test
    void test1() {

        assertThat(reverse(-100)).isEqualTo(-1);
    }
    public int reverse(int x) {
        long res = 0;

        while (x != 0) {
            res = res*10 + x%10;
            x /= 10;
        }

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) res;
    }
}
