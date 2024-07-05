package dev.turbin.leetcode.interview.medium.map;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 */
public class GroupAnagrams {

    //It works, but can't check
    @Test
    void test1() {
        assertThat(Set.of(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"})))
                .isEqualTo(Set.of(List.of(List.of("bat"), List.of("nat","tan"), List.of("ate","eat","tea"))));
    }

    //To slow
    public List<List<String>> groupAnagrams(String[] strs) {
       byte[][] matrix = new byte[strs.length][];

        for (int i = 0; i < strs.length; i++) {
            matrix[i] = new byte[30];
            for (int j = 0; j < strs[i].length(); j++) {
                matrix[i][strs[i].charAt(j)-'a']++;
            }
        }

        List<List<String>> result = new ArrayList<>(strs.length/2);

        for (int i = 0; i < strs.length; i++) {
            if (matrix[i] != null) {

                List<String> list = new ArrayList<>();
                list.add(strs[i]);

                for (int j = i+1; j < strs.length; j++) {
                    if (matrix[j] != null && Arrays.equals(matrix[i], matrix[j])) {
                        list.add(strs[j]);
                        matrix[j] = null;
                    }
                }

                result.add(list);
            }
        }

        return result;
    }

    //Better
    public List<List<String>> groupAnagramsFromLeetCode(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
