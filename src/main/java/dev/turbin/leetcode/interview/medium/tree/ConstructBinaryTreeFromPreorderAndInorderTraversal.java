package dev.turbin.leetcode.interview.medium.tree;

import dev.turbin.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static dev.turbin.leetcode.interview.easy.tree.SameTree.isSameTree;
import static org.assertj.core.api.Assertions.assertThat;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    @Test
    void test1() {
        TreeNode first = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        assertThat(isSameTree(buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}), first))
                .isEqualTo(true);
    }

    @Test
    void test2() {
        TreeNode first = new TreeNode(1, new TreeNode(2), null);

        assertThat(isSameTree(buildTree(new int[]{1,2}, new int[]{2,1}), first))
                .isEqualTo(true);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        if (preorder.length == 1) {
            return root;
        }

        int rootIndex = 0;
        while (inorder[rootIndex] != preorder[0]) {
            rootIndex++;
        }

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIndex+1), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, rootIndex+1, preorder.length), Arrays.copyOfRange(inorder, rootIndex+1, inorder.length));

        return root;
    }

}
