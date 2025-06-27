package com.vivek.heap.problems;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianProblems {

    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 11, 20, 2, 1};
        MedianProblems median = new MedianProblems();
        median.median(arr);
    }

    public void median(int[] arr) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(arr[0]);
        System.out.println(maxHeap.peek());

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < maxHeap.peek()) {
                maxHeap.add(arr[i]);
            } else {
                minHeap.add(arr[i]);
            }
            int difference = Math.abs(minHeap.size() - maxHeap.size());
            if (difference > 1) {
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                } else {
                    minHeap.add(maxHeap.poll());
                }
            }
            if (maxHeap.size() > minHeap.size()) {
                System.out.println(maxHeap.peek());
            } else if (minHeap.size() > maxHeap.size()) {
                System.out.println(minHeap.peek());
            } else {
                System.out.println((maxHeap.peek() + minHeap.peek()) / 2.0);
            }
        }
    }
}