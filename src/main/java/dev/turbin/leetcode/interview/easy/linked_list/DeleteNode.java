package dev.turbin.leetcode.interview.easy.linked_list;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * There is a singly-linked list head and we want to delete a node node in it.
 * You are given the node to be deleted node. You will not be given access to the first node of head.
 * All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.
 * Delete the given node.
 */
@SpringBootTest
public class DeleteNode {


    @Test
    void test1() {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution solution = new Solution();
        solution.deleteNode(node2);

        assertThat(node1.next.val).isEqualTo(node3.val);
    }

    class Solution {
        public void deleteNode(ListNode node) {
           node.val = node.next.val;
           node.next = node.next.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
