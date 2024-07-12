package dev.turbin.leetcode.daily;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.get;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
 * Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
 */
//TODO: unsolved
@SpringBootTest
public class IPO {

    @Test
    void test1() {
        assertThat(findMaximizedCapital(2, 0, new int[]{1,2,3}, new int[]{0,1,1}))
                .isEqualTo(4);
    }

    @Test
    void test2() {
        assertThat(findMaximizedCapital(10, 0, new int[]{1,2,3}, new int[]{0,1,2}))
                .isEqualTo(6);
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        Map<Integer, List<Integer>> map = new HashMap<>(capital.length);

        for (int i = 0; i < capital.length; i++) {
            if (map.containsKey(capital[i])) {
                map.get(capital[i]).add(profits[i]);
            } else {
                List<Integer> list = new ArrayList<>(capital.length/10 + 1);
                list.add(profits[i]);
                map.put(capital[i], list);
            }
        }

        map.forEach((c,v) -> v.sort(Comparator.reverseOrder()));

        for (int i = 0; i < k; i++) {

            int j = 0;
            while (!map.containsKey(w-j)) {
                j++;
            }

            List<Integer> integers = map.get(w - j);
            int buf = integers.get(0);

            if (integers.size() == 1) {
                map.remove(w-j);
            } else {
                integers.remove(0);
            }

            w += buf;

            if (map.isEmpty()) {
                return w;
            }


        }

        return w;

    }

    //too slow
    public int findMaximizedCapital1(int k, int w, int[] profits, int[] capital) {

        byte[] indices = new byte[capital.length];


        for (int i = 0; i < k; i++) {

            int maxProfitForIteration = 0;
            int indexOfMaxProfitForIteration = -1;

            for (int j = 0; j < capital.length; j++) {
                if (indices[j] == 0 && profits[j] > maxProfitForIteration && capital[j] <= w) {
                    indexOfMaxProfitForIteration = j;
                    maxProfitForIteration = profits[j];
                }
            }

            if (indexOfMaxProfitForIteration != -1) {
                indices[indexOfMaxProfitForIteration]++;
                w += maxProfitForIteration;
            }
        }

        return w;

    }
}
