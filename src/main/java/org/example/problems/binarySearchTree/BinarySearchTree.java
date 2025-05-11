package org.example.problems.binarySearchTree;

import org.example.model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {
    public static boolean search(TreeNode root, int key) {
        if (root == null) return false;
        if (key == root.val) return true;
        if (key > root.val) {
            return search(root.right, key);
        } else {
            return search(root.left, key);
        }
    }

    public static TreeNode insert(TreeNode root, int key) {
        if (root == null) return new TreeNode(key);
        if (root.val == key) return root;
        if (key > root.val) {
            root.right = insert(root.right, key);
        } else {
            root.left = insert(root.left, key);
        }
        return root;
    }

    public static int smallest(TreeNode root) {
        if (root.left == null) return root.val;
        return smallest(root.left);
    }

    public static TreeNode delete(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null && root.right == null) return null;
            TreeNode replaceOfNode = maxOfLeftSubTree(root.left);
            if (replaceOfNode == null) return null;
            root.val = replaceOfNode.val;
            root.left = delete(root.left, replaceOfNode.val);
        } else if (key > root.val) {
            root.right = delete(root.right, key);
        } else {
            root.left = delete(root.left, key);
        }
        return root;
    }

    private static TreeNode maxOfLeftSubTree(TreeNode root) {
        if (root == null) return null;
        if (root.right == null) return root;
        return maxOfLeftSubTree(root.right);
    }

    public static TreeNode createBSTUsingSortedArray(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = createBSTUsingSortedArray(array, start, mid - 1);
        root.right = createBSTUsingSortedArray(array, mid + 1, end);
        return root;
    }

    public static String isValidPreorderWithOneChild(int[] preOrder) {
        int min = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        if (preOrder.length == 1) return "valid";
        for (int index = 0; index < preOrder.length; index++) {
            if (preOrder[index] < min) {
                return "Not valid";
            }
            while (!stack.isEmpty() && preOrder[index] > stack.peek()) {
                min = stack.pop();
                root = min;
            }
            if (preOrder[index] > root && root > preOrder[index - 1]) return "Not valid";
            stack.push(preOrder[index]);
        }
        return "valid";
    }


    public static void printTree(TreeNode root) {
        int maxLevel = maxDepth(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                System.out.print(" ");
                newNodes.add(null);
                newNodes.add(null);
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(edgeLines + edgeLines - i);
            }
            System.out.println();
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxDepth(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }
        return true;
    }

}
