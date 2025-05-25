package org.example.problems.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MiddleElement {
    public static void main(String[] args) {
        List<Integer> head = new LinkedList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8));


    }

    public static void split(String str) {
        int[] prefixSum = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            prefixSum[i] = i == 0 ? str.charAt(i) : prefixSum[i - 1] + str.charAt(i);
        }
        System.out.println(Arrays.toString(prefixSum));
    }
}
