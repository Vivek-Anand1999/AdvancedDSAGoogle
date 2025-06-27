package com.vivek.dynamicProgramming;

import com.vivek.model.TreeNode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Square {
    public static void main(String[] args) {
        Queue<TreeNode> queue = new PriorityQueue<>();
        queue.offer(new TreeNode(1));
        queue.offer(new TreeNode(2));
        int n = 4;
        int[]momo = new int[n+1];
        Arrays.fill(momo, -1);
        System.out.println(foo(n,momo));
    }
    public static int foo(int n,int[]momo){
        if(n == 0) return 0;
        if(momo[n]!=-1) return momo[n];
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i * i <= n; i++){
            ans = Math.min(ans,foo(n-(i*i),momo));
        }
        momo[n]=ans+1;
        return momo[n];
    }
}
