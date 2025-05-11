package org.example.problems;

import org.example.model.TreeNode;

public class CheckTreeDivideEqualPart {
    static boolean isExist = false;

    public static int checkTreeDivideEqualPart(TreeNode root, int target) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int leftValue = checkTreeDivideEqualPart(root.left, target);
        int rightValue = checkTreeDivideEqualPart(root.right, target);
        if (leftValue == target || rightValue == target) {
            isExist = true;
        }
        return root.val + leftValue + rightValue;
    }


    public static boolean state() {
        return isExist;
    }


}
