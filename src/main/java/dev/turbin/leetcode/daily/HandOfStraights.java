package dev.turbin.leetcode.daily;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize,
 * and consists of groupSize consecutive cards.
 */

public class HandOfStraights {

    @Test
    void test1() {
        assertThat(isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3)).isEqualTo(true);
    }

    @Test
    void test2() {
        assertThat(isNStraightHand(new int[]{1,2,3,4,5}, 4)).isEqualTo(false);
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int j : hand) {
            Integer i1 = map.get(j);
            map.put(j, i1 == null ? 1 : i1 + 1);
        }

        Map.Entry<Integer, Integer> entry = null;
        for (int i = 0; i < hand.length; i++) {

            if (i%groupSize == 0) {
                System.out.println("group: ");
                entry = map.firstEntry();
            } else {
                entry = map.ceilingEntry(entry.getKey()+1);
            }

            if (i%groupSize != groupSize -1 && map.get(entry.getKey() + 1) == null) {
                return false;
            }

            System.out.println(entry.getKey());
            if (entry.getValue() == 1) {
                map.remove(entry.getKey());
            } else {
                map.put(entry.getKey(), entry.getValue()-1);
            }
        }

        return true;
    }
}
