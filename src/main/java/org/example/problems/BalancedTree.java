package org.example.problems;

import org.example.model.TreeNode;

public class BalancedTree {
    public static int balanced(TreeNode root) {
        if (root == null) return -1;
        int left = balanced(root.left);
        int right = balanced(root.right);
        if (Math.abs(left - right) > 1) return -1;
        else return Math.max(left, right) + 1;
    }
}
