package com.vivek.utils;

import com.vivek.model.TreeNode;

public class TreeOperations {
    public static int nodeSum(TreeNode root) {
        int sum = 0;
        if (root == null) return 0;
        sum += root.val;
        sum += nodeSum(root.left);
        sum += nodeSum(root.right);
        return sum;
    }
    public static int nonLeafNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null || root.right != null) {
            return 1 + nonLeafNodes(root.left) + nonLeafNodes(root.right);
        }
        return 0;
    }
    public static int leafNodes(TreeNode root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null) {
            return 1;
        }
        return leafNodes(root.left) + leafNodes(root.right);

    }
    public static int totalNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + totalNodes(root.left) + totalNodes(root.right);
    }
    public static int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }

    public static TreeNode insertBst(TreeNode root, int key) {
        if (root == null) {
            TreeNode pointer = new TreeNode(key);
            return pointer;
        }
        if (root.val == key) {
            return root;
        } else if (key < root.val) {
            root.left = insertBst(root.left, key);
        } else {
            root.right = insertBst(root.right, key);
        }
        return root;
    }

    public static TreeNode deleteInBst(TreeNode root, int key){
        if(root == null) return null;
        if(root.left == null && root.right == null){
            return null;
        }
        if(root.val == key){
            if(heightOfTree(root.left) > heightOfTree(root.right)){
                TreeNode temp = inOrderPre(root.left);
                root.val = temp.val;
                root.left = deleteInBst(root.left,temp.val);
            }else {
                TreeNode temp = inOrderSuccessor(root.right);
                root.val = temp.val;
                root.right = deleteInBst(root.right,temp.val);
            }

        } else if (key < root.val) {
            root.left = deleteInBst(root.left,key);
        }else{
            root.right = deleteInBst(root.right,key);
        }
        return root;
    }
    private static TreeNode inOrderPre(TreeNode root){
        if(root == null) return null;
        if(root.right == null){
            return root;
        }
        return inOrderPre(root.right);
    }
    private static TreeNode inOrderSuccessor(TreeNode root){
        if(root == null) return null;
        if(root.left == null){
            return root;
        }
        return inOrderSuccessor(root.left);
    }
}
