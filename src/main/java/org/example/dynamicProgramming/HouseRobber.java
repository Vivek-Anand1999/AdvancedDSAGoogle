package org.example.dynamicProgramming;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] array = {2, 7, 9, 3, 1};
        int[] dp = new int[array.length + 2];
        Arrays.fill(dp, -1);
        System.out.println(foo(0, dp, array.length, array));
    }

    public static int foo(int idx, int[] dp, int n, int[] array) {
        if (idx > n) return 0;
        if (dp[idx] != -1) return dp[idx];
        int pick = array[idx] + foo(idx + 2, dp, n, array);
        int skip = foo(idx + 1, dp, n, array);
        dp[idx] = Math.max(pick, skip);
        return dp[idx];
    }
}
