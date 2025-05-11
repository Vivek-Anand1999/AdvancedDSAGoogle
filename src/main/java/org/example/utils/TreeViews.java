package org.example.utils;

import org.example.model.TreeNode;

import java.util.*;

public class TreeViews {
    public static int maximumLevel = 0;

    // Wrapper class to keep track of max level
    static class LevelTracker {
        int val = 0;
    }

    public static void bottomViewIter(TreeNode root) {
        Queue<Tuple> queue = new LinkedList<>();
        TreeMap<Integer, Map<Integer, Integer>> map = new TreeMap<>();
        queue.add(new Tuple(0, 1, root));

        while (!queue.isEmpty()) {
            Tuple temp = queue.poll();
            TreeNode pointer = temp.node;
            int vertical = temp.vertical;
            int level = temp.level;

            map.put(vertical, new HashMap<>());
            map.get(vertical).put(level, pointer.val);

            if (pointer.left != null) {
                queue.add(new Tuple(vertical - 1, level + 1, pointer.left));
            }
            if (pointer.right != null) {
                queue.add(new Tuple(vertical + 1, level + 1, pointer.right));
            }
        }
        System.out.println(map.toString());
        for (Map<Integer, Integer> entry : map.values()) {
            for (int val : entry.values()) {
                System.out.print(val + " ");
            }
        }
    }
    public static void leftViewOfLeftSubtree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        leftViewOfLeftSubtree(root.left);
        if (root.left == null) {
            leftViewOfLeftSubtree(root.right);
        }
    }

    public static void leftView(TreeNode root){

        leftViewTree(root,1, new LevelTracker());
    }
    public static void leftViewTree(TreeNode root, int level, LevelTracker tracker) {
        if (root == null) {
            return;
        }
        if (level > tracker.val) {
            System.out.print(root.val + " ");
            tracker.val = level;
        }
        leftViewTree(root.left, level + 1,tracker);
        leftViewTree(root.right, level + 1, tracker);
    }

    public static void rightView(TreeNode root){

        rightViewTree(root,1, new LevelTracker());
    }
    public static void rightViewTree(TreeNode root, int level, LevelTracker  tracker) {
        if (root == null) {
            return;
        }
        if (level > tracker.val) {
            System.out.print(root.val + " ");
            tracker.val = level;
        }
        rightViewTree(root.right, level + 1, tracker);
        rightViewTree(root.left, level + 1,tracker);
    }

}
