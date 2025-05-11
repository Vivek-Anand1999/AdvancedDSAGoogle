package org.example;

import org.example.model.TreeNode;
import org.example.problems.CheckTreeDivideEqualPart;

public class Main {

    public static void main(String[] args) {

        TreeNode head = new TreeNode(0);
        head.left = new TreeNode(-1);
        head.right = new TreeNode(1);

        CheckTreeDivideEqualPart.checkTreeDivideEqualPart(head, 0);
        System.out.println(CheckTreeDivideEqualPart.state());
    }

}
