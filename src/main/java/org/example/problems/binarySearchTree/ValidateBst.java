package org.example.problems.binarySearchTree;

import org.example.model.TreeNode;

public class ValidateBst {
    public static int isValid(TreeNode root, int maxValue, int minValue) {
        if (root == null) return 1;
        if (root.val >= maxValue || root.val <= minValue) return 0;
        int left = isValid(root.left, root.val, minValue);
        int right = isValid(root.right, maxValue, root.val);
        return left & right;
    }
}
