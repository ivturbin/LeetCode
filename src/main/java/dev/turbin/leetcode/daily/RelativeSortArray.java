package dev.turbin.leetcode.daily;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
 * Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
 */
@SpringBootTest
public class RelativeSortArray {

    @Test
    void test1() {
        assertThat(relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6})).isEqualTo(new int[] {2,2,2,1,4,3,3,9,6,7,19});
    }

    @Test
    void test2() {
        assertThat(relativeSortArray(new int[]{2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31}, new int[]{2,42,38,0,43,21}))
                .isEqualTo(new int[] {2,42,38,0,43,21,5,7,12,12,13,23,24,24,27,29,30,31,33,48});
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>(arr2.length);
        Map<Integer, Integer> others = new HashMap<>(arr1.length - arr2.length);
        for (int j : arr2) {
            map.put(j, 0);
        }
        for (int j : arr1) {
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
            } else {
                others.put(j, others.getOrDefault(j, 0)+1);
            }
        }

        int[] j = {0};
        for (int value : arr2) {
            for (int k = 0; k < map.get(value); k++) {
                arr1[j[0]] = value;
                j[0]++;
            }
        }

        others.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .forEach(integerIntegerEntry -> {
                    for (int i = 0; i < integerIntegerEntry.getValue(); i++) {
                        arr1[j[0]] = integerIntegerEntry.getKey();
                        j[0]++;
                    }
                });

        return arr1;
    }

}
