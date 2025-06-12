package org.example.heap.problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class Rope_problems {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : arr) {
            queue.add(num);
        }
        int result = 0;
        while (queue.size() > 1) {
            int firstValue = queue.poll();
            int secondValue = queue.poll();
            int ans = firstValue + secondValue;
            result += ans;
            queue.add(ans);
        }
        System.out.println(result);
    }

}
