package org.example;

import org.example.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
//        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
//        head.left.left.left = new TreeNode(8);
//        head.left.left.right = new TreeNode(9);
//        head.left.right.right = new TreeNode(10);
//        head.right.right.left = new TreeNode(12);
//        head.right.right.right = new TreeNode(13);
        levelOrder(head);

    }

    public static void levelOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Add current value
            list.add(current.val);

            // Handle left child
            if (current.left != null) {
                queue.offer(current.left);
            } else if (current.right != null) {
                // add fake node for missing left child
                queue.offer(new TreeNode(-1));
            }

            // Handle right child
            if (current.right != null) {
                queue.offer(current.right);
            } else if (current.left != null) {
                queue.offer(new TreeNode(-1));
            }
        }
        System.out.println(list);

    }

}
