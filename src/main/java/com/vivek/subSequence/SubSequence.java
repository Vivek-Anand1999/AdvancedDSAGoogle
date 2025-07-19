package com.vivek.subSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSequence {
    public static void main(String[] args) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int[] array = {1, 2, 1, 3, 1, 1, 2};
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        int[][] dp = new int[array.length + 1][sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }


        System.out.println(lcs("abcde", "acde", 0, 0));

    }

    public static void printSubSequence(int index, int[] array, List<Integer> current, List<List<Integer>> result) {
        if (index == array.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(array[index]);
        printSubSequence(index + 1, array, current, result);
        current.remove(current.size() - 1);
        printSubSequence(index + 1, array, current, result);
    }

    public static int maxSubSequence(int idx, int[] array) {
        if (idx == array.length) {
            return 0;
        }
        int select = array[idx] + maxSubSequence(idx + 1, array);
        int notSelect = maxSubSequence(idx + 1, array);
        return Math.max(select, notSelect);
    }

    public static void check(String original, String match) {
        int firstPointer = 0;
        int lastPointer = original.length() - 1;
        int i = 0;
        int j = match.length() - 1;
        int flag = 0;
        boolean casse = false;
        if (match.length() > original.length()) {
            System.out.println(false);
            return;
        }
        while (firstPointer <= lastPointer && i <= j) {
            if (i <= j && original.charAt(firstPointer) == match.charAt(i)) {
                firstPointer++;
                i++;
                flag++;
                casse = true;
            }
            if (i <= j && firstPointer < lastPointer && original.charAt(lastPointer) == match.charAt(j)) {
                lastPointer--;
                j--;
                flag++;
                casse = true;
            }
            if (!casse) {
                firstPointer++;
                lastPointer--;

            }
            casse = false;
        }
        if (flag == match.length()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static int targetSumSubSequence(int idx, int sum, int[] array, int target, int[][] dp) {
        if (idx == array.length) {
            return sum == target ? 1 : 0;
        }
        if (dp[idx][sum] != -1) {
            return dp[idx][sum];
        }
        int pick = targetSumSubSequence(idx + 1, sum + array[idx], array, target, dp);
        int skip = targetSumSubSequence(idx + 1, sum, array, target, dp);
        dp[idx][sum] = pick + skip;
        return dp[idx][sum];
    }

    public static int lcs(String s1, String s2, int indexOfS1, int indexOfS2) {
        if (indexOfS1 == s1.length() || indexOfS2 == s2.length()) {
            return 0;
        }
        if (s1.charAt(indexOfS1) == s2.charAt(indexOfS2)) {
            return 1 + lcs(s1, s2, indexOfS1 + 1, indexOfS2 + 1);
        } else {
            return Math.max(lcs(s1, s2, indexOfS1 + 1, indexOfS2), lcs(s1, s2, indexOfS1, indexOfS2 + 1));
        }
    }
}
