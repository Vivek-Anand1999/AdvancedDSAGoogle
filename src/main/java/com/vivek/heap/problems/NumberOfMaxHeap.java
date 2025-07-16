package com.vivek.heap.problems;

import java.util.Arrays;

public class NumberOfMaxHeap {
    public static void main(String[] args) {
        int n = 100; // 812145033
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        int mod = 1000000007;
        System.out.println(generatingNumberOfTree(100, dp, mod));
    }

    public static long generatingNumberOfTree(int n, long[] dp, int mod) {
        if (n <= 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        int l = findingLeftNode(n);
        long com = combinations((n - 1), l, mod);
        long left = generatingNumberOfTree(l, dp, mod);
        long right = generatingNumberOfTree((n - 1) - l, dp, mod);
        dp[n] = ((com * left) % mod * right) % mod;
        return dp[n];

    }

    public static int findingLeftNode(int n) {
        int height = (int) Math.floor(Math.log(n) / Math.log(2));
        int numberOfNodeAtBeforeLast = (int) Math.pow(2, height) - 1;
        int totalNumberOfNodeAtLastLevel = n - numberOfNodeAtBeforeLast;
        int leftHeight = height - 1;
        int totalNumberOfNodeOnLeftSideExceptLeafNode = (int) Math.pow(2, leftHeight) - 1;
        int totalNodeAtLeft = totalNumberOfNodeOnLeftSideExceptLeafNode
                + Math.min(totalNumberOfNodeAtLastLevel, (int) Math.pow(2, leftHeight));
        return totalNodeAtLeft;
    }

    private static int combinations(int n, int r, int mod) {
        if (r == 0 || r == n)
            return 1;
        long nFact = factorial(n, mod);
        long rFact = factorial(r, mod);
        long nMinusRFact = factorial(n - r, mod);

        long denominator = (rFact * nMinusRFact) % mod;
        long inverse = modInverse(denominator, mod);

        return (int) ((nFact * inverse) % mod);
    }

    private static long modInverse(long denominator, int mod) {
        long denominatorInverse = powerMod((int) denominator, mod - 2, mod);
        return denominatorInverse % mod;
    }
 
    private static long powerMod(long base, long exp, int mod) {
        if (exp == 0) return 1;
        long result = powerMod(base, exp / 2, mod);
        if (exp % 2 == 0) return (result * result) % mod;
        return ((result * result) % mod * base) % mod;
    }

    private static int factorial(int n, int mod) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = (result * i) % mod;
        }
        return (int) result;
    }

}
