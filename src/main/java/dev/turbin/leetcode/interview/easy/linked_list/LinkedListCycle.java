package dev.turbin.leetcode.interview.easy.linked_list;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LinkedListCycle {

    @Test
    void test1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        assertThat(hasCycleFromLeetCode(node1)).isEqualTo(true);
    }

    @Test
    void test2() {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        assertThat(hasCycleFromLeetCode(node1)).isEqualTo(false);
    }

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        Set<ListNode> set = new HashSet<>(10001);
        ListNode node = head;

        while (node.next != null) {
            if (set.contains(node)) {
                return true;
            }
            set.add(node);
            node = node.next;
        }

        return false;
    }

    //Better from LeetCode
    public boolean hasCycleFromLeetCode(ListNode head) {
        if(head == null || head.next == null)return false;
        ListNode f = head;
        ListNode s = head;
        while(f != null && f.next != null){
            f= f.next.next;
            s=s.next;
            if(f == s)return true;
        }
        return false;
    }

    /**
     * Definition for singly-linked list.
     **/
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


}
