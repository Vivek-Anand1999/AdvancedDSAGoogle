package org.example.dynamicProgramming;

import java.util.Arrays;

public class Fibonacci {
    public static int[] array;

    public static void main(String[] args) {
        int x = 8;
        array = new int[x + 1];
        Arrays.fill(array, -1);


    }

    public int fibonacci(int n) {
        if (n <= 1) return n;
        return 0;
    }
}
