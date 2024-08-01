package dev.turbin.leetcode.interview.easy.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaximumDepth {



    @Test
    void test1() {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        assertThat(maxDepth(root))
                .isEqualTo(3);
    }

    @Test
    void test2() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2));

        assertThat(maxDepth(root))
                .isEqualTo(2);
    }

    public int maxDepth(TreeNode root) {

        int depth = 0;

        return maxDepthRecursive(root, depth);
    }

    private int maxDepthRecursive(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        depth++;
        return Math.max(maxDepthRecursive(root.left, depth), maxDepthRecursive(root.right, depth));
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
