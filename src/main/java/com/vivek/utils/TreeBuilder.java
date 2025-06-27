package com.vivek.utils;

import com.vivek.model.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeBuilder {

    public static TreeNode createBinaryTreeIter() {
        Queue<TreeNode> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the root node value");
        int input = scanner.nextInt();
        TreeNode root = new TreeNode(input);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode pointer = queue.poll();
            System.out.println("If you want left child of " + pointer.val + " left Subtree the enter value other wise enter -1");
            int needLeftChild = scanner.nextInt();
            if (needLeftChild > -1) {
                TreeNode leftChild = new TreeNode(needLeftChild);
                pointer.left = leftChild;
                queue.add(leftChild);
            }
            System.out.println("If you want right child of " + pointer.val + " in the right subtree then enter value, otherwise enter -1:");
            int needRightChild = scanner.nextInt();
            if (needRightChild > -1) {
                TreeNode rightChild = new TreeNode(needRightChild);
                pointer.right = rightChild;
                queue.add(rightChild);
            }
        }
        return root;
    }


    public static TreeNode buildFromPreOrderInOrder(int[] preOrder, int[] inOrder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int index = 0; index < inOrder.length; index++) {
            inMap.put(inOrder[index], index);
        }
        return generatePreOrderInOrder(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, inMap);
    }

    private static TreeNode generatePreOrderInOrder(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd,
                                 HashMap<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        int rootValue = preOrder[preStart];
        int rootIndex = inMap.get(rootValue);
        int leftCount = rootIndex - inStart;
        TreeNode root = new TreeNode(rootValue);
        root.left = generatePreOrderInOrder(preOrder, preStart + 1, preStart + leftCount, inOrder, inStart, rootIndex - 1, inMap);
        root.right = generatePreOrderInOrder(preOrder, preStart + leftCount + 1, preEnd, inOrder, rootIndex + 1, inEnd, inMap);
        return root;
    }


}
