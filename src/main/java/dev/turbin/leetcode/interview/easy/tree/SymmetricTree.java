package dev.turbin.leetcode.interview.easy.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SymmetricTree {

    @Test
    void test1() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));

        assertThat(isSymmetric(root))
                .isEqualTo(true);
    }

    public boolean isSymmetric(TreeNode root) {
        return equalsRecursive(root.left, root.right);
    }

    private boolean equalsRecursive(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return equalsRecursive(left.left, right.right) && equalsRecursive(left.right, right.left);
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
