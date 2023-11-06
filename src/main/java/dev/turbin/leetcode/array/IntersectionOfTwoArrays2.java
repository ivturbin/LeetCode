package dev.turbin.leetcode.array;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays, and you may return the result in any order.
 */
@SpringBootTest
public class IntersectionOfTwoArrays2 {

    @Test
    void test1() {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        assertThat(intersect(nums1, nums2)).isEqualTo(new  int[]{2,2});
    }

    @Test
    void test2() {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        assertThat(intersect(nums1, nums2)).isEqualTo(new  int[]{4,9});
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] ind1 = new int[1001];

        for (int i = 0; i < nums1.length; i++) {
            ind1[nums1[i]]++;
        }

        List<Integer> list = new ArrayList<>(nums1.length < nums2.length ?  nums1.length : nums2.length);

        for (int j : nums2) {
            if (ind1[j] != 0) {
                list.add(j);
                ind1[j]--;
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public int[] intersectV2(int[] nums1, int[] nums2) {
        int[] ind1 = new int[1001];
        int[] ind2 = new int[1001];

        for (int i = 0; i < nums1.length; i++) {
            ind1[nums1[i]]++;
        }

        for (int i = 0; i < nums2.length; i++) {
            ind2[nums2[i]]++;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < ind1.length; i++) {
            if (ind1[i] != 0 && ind2[i] != 0) {
                int count = ind1[i] < ind2[i] ? ind1[i] :ind2[i];
                for (int j = 0; j < count; j++) {
                    list.add(i);
                }
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }


    public int[] intersectV1(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>(nums1.length);
        HashMap<Integer, Integer> map2 = new HashMap<>(nums2.length);
        for (int j : nums1) {
            if (map1.containsKey(j)) {
                map1.put(j, map1.get(j) + 1);
            } else {
                map1.put(j, 1);
            }
        }

        for (int j : nums2) {
            if (map2.containsKey(j)) {
                map2.put(j, map2.get(j) + 1);
            } else {
                map2.put(j, 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        map1.forEach((k, v1) -> {
            if (map2.containsKey(k)) {
                int v2 = map2.get(k);
                if (v2 > 0) {
                    int count = v1 < v2 ? v1 : v2;
                    for (int i = 0; i < count; i++) {
                        list.add(k);
                    }
                }
            }
        });


        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
