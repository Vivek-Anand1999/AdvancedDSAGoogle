package org.example.problems.binaryTree;

import org.example.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public static int[] serializeBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> array = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                array.add(temp.val);
            } else {
                array.add(-1);
            }

            if (temp != null && temp.left == null) {
                queue.add(null);
            }
            if (temp != null && temp.left != null) {
                queue.add(temp.left);
            }
            if (temp != null && temp.right == null) {
                queue.add(null);
            }
            if (temp != null && temp.right != null) {
                queue.add(temp.right);
            }

        }

        int[] result = new int[array.size()];

        for (int index = 0; index < array.size(); index++) {
            result[index] = array.get(index);

        }

        return result;

    }

    public static TreeNode deserializeBinaryTree(int[] array) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int index = 1; index < array.length; index += 2) {
                TreeNode temp = queue.poll();
                temp.left = array[index] == -1 ? null : new TreeNode(array[index]);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                temp.right = array[index + 1] == -1 ? null : new TreeNode(array[index + 1]);
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return root;
    }

    public static int totalSum(TreeNode root) {
        int sum = 0;
        if (root == null) return 0;
        sum += root.val;
        sum += totalSum(root.left);
        sum += totalSum(root.right);
        return sum;


    }
}
