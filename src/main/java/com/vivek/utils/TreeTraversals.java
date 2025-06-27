package com.vivek.utils;

import com.vivek.model.TreeNode;

import java.util.*;

import static com.vivek.utils.TreeOperations.heightOfTree;

public class TreeTraversals {

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void levelOrderRecHelper(TreeNode root) {
        if (root == null)
            return;
        int height = heightOfTree(root);
        for (int level = 1; level <= height; level++) {
            levelOrder(root, level);
        }

    }

    private static void levelOrder(TreeNode root, int level) {
        if (root == null)
            return;
        if (level == 1) {
            System.out.print(root.val + " ");
        } else {
            levelOrder(root.left, level - 1);
            levelOrder(root.right, level - 1);
        }
    }

    public static void levelOrderIter(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Deque<Integer> dq = new LinkedList<>();
        TreeNode temp = root;
        queue.add(temp);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            System.out.print(temp.val + "  ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    public static void postOrderIter(TreeNode node) {
        TreeNode temp = node;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        while (!stack1.isEmpty() || temp != null) {
            if (temp != null) {
                stack1.push(temp);
                temp = temp.left;
            } else {
                temp = stack1.pop();
                if (!stack2.isEmpty() && stack2.peek() == temp) {
                    System.out.print(temp.val + "  ");
                    stack2.pop();
                    temp = null;
                } else {
                    stack2.push(temp);
                    stack1.push(temp);
                    temp = temp.right;
                }
            }
        }
    }

    public static void verticalOrderIter(TreeNode root) {
        Queue<Tuple> queue = new LinkedList<>();
        Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
        queue.add(new Tuple(0, 1, root));

        while (!queue.isEmpty()) {
            Tuple temp = queue.poll();
            TreeNode pointer = temp.node;
            int vertical = temp.vertical;
            int level = temp.level;
            if (!map.containsKey(vertical)) {
                map.put(vertical, new HashMap<>());
            }
            if (!map.get(vertical).containsKey(level)) {
                map.get(vertical).put(level, new ArrayList<>());
            }
            map.get(vertical).get(level).add(pointer.val);

            if (pointer.left != null) {
                queue.add(new Tuple(vertical - 1, level + 1, pointer.left));
            }
            if (pointer.right != null) {
                queue.add(new Tuple(vertical + 1, level + 1, pointer.right));
            }

        }
        System.out.println(map.toString());
    }
}
