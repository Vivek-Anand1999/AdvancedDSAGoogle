package org.example.heap.problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinLargestElement {
    public static void main(String[] args) {
        foo(new int[]{5, 1, 4, 2}, 5);

    }

    public static void foo(int[] array, int operation) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < array.length; i++) {
            queue.add(new int[]{array[i] + array[i], i});
        }
        int operationLeft = operation;
        while (operationLeft > 0) {
            int[] temp = queue.poll();
            int val = temp[0] + array[temp[1]];
            queue.add(new int[]{val, temp[1]});
            operationLeft--;
        }

        int max = 0;
        for (int[] num : queue) {
            System.out.println(Arrays.toString(num));
        }
        System.out.println(max);
    }
}