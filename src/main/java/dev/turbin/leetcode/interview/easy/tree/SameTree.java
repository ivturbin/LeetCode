package dev.turbin.leetcode.interview.easy.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SameTree {

    @Test
    void test1() {
        TreeNode first = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode second = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        assertThat(isSameTree(first, second))
                .isEqualTo(true);
    }

    @Test
    void test2() {
        TreeNode first = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode second = new TreeNode(1, new TreeNode(3), new TreeNode(2));

        assertThat(isSameTree(first, second))
                .isEqualTo(false);
    }

    @Test
    void test3() {
        TreeNode first = new TreeNode(1, null, new TreeNode(2, new TreeNode(4, null, new TreeNode(3)), null));
        TreeNode second = new TreeNode(1, null, new TreeNode(4, new TreeNode(2, null, new TreeNode(3)), null));


        assertThat(isSameTree(first, second))
                .isEqualTo(false);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeRecursive(p, q);
    }

    private boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        } else {
            return isSameTreeRecursive(p.left, q.left) && isSameTreeRecursive(p.right, q.right);
        }

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
