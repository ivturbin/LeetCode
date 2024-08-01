package dev.turbin.leetcode.interview.easy.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InvertTree {

    @Test
    void test1() {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        assertThat(invertTree(root))
                .isEqualTo(3);
    }

    public TreeNode invertTree(TreeNode root) {
        return invertTreeRecursive(root);
    }

    private TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        invertTreeRecursive(root.left);
        invertTreeRecursive(root.right);

        return root;
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
