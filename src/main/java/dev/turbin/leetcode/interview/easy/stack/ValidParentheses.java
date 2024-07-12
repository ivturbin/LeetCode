package dev.turbin.leetcode.interview.easy.stack;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 */
public class ValidParentheses {

    @Test
    void test1() {
        assertThat(isValid("()[]{}"))
                .isEqualTo(true);
    }

    @Test
    void test2() {
        assertThat(isValid("(]"))
                .isEqualTo(false);
    }

    @Test
    void test3() {
        assertThat(isValid("()"))
                .isEqualTo(true);
    }

    @Test
    void test4() {
        assertThat(isValid("(("))
                .isEqualTo(false);
    }

    @Test
    void test5() {
        assertThat(isValid("){"))
                .isEqualTo(false);
    }

    public boolean isValid(String s) {

        if (s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>(3);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack1 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack1.push(c);
            } else {
                if (stack1.isEmpty() || map.get(stack1.pop()) != c) {
                    return false;
                }
            }
        }

        return stack1.isEmpty();
    }
}
