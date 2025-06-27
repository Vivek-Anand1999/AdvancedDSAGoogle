package com.vivek.problems;

import com.vivek.model.TreeNode;

public class PathSum {
    public static int pathSum(TreeNode root, int targetSum, int pathSum) {
        if( root == null) return 0;
        pathSum += root.val;
        if(root.left == null && root.right == null){
            if(pathSum == targetSum) return 1;
            else return 0;
        }
        int left = pathSum(root.left,targetSum,pathSum);
        int right = pathSum(root.right,targetSum,pathSum);
        return left+right;
    }
}
