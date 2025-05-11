package org.example.utils;

import org.example.model.TreeNode;

public class Tuple {
    public int vertical;
    public int level;
    public TreeNode node;

    Tuple(int vertical, int level, TreeNode node) {
        this.node = node;
        this.level = level;
        this.vertical = vertical;
    }
}
