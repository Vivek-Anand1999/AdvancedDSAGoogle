package org.example.heap;

import java.util.Arrays;

public class MaxHeap {
    public static int capacity;
    public static int size;
    public static int[] heap;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public static void insert(int value) {
        if (size == capacity) {
            return;
        }
        heap[size++] = value;
        int index = size - 1;
        int parentIndex = (index - 1) / 2;
        while (heap[index] > heap[parentIndex]) {
            int temp = heap[index];
            heap[index] = heap[parentIndex];
            heap[parentIndex] = temp;
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public static void delete() {
        int removeElement = heap[0];
        int lastLeaf = heap[size - 1];
        heap[size - 1] = -1;
        heap[0] = lastLeaf;
        size--;
        int index = 0;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        while (leftChildIndex < size || rightChildIndex < size) {
            int leftChildValue = heap[leftChildIndex];
            int rightChildValue = heap[rightChildIndex];
            
            if (leftChildValue > rightChildValue && leftChildValue > heap[index]) {
                swap(heap, leftChildIndex, index);
                index = leftChildIndex;
            } else if (rightChildValue > leftChildValue && rightChildValue > heap[index]) {
                swap(heap, rightChildIndex, index);
                index = rightChildIndex;
            }
            if (heap[index] > leftChildValue && heap[index] > rightChildValue) {
                break;
            }

            leftChildIndex = index * 2 + 1;
            rightChildIndex = index * 2 + 2;
        }

    }

    private static void swap(int[] heap, int rightChildIndex, int index) {
        int temp = heap[rightChildIndex];
        heap[rightChildIndex] = heap[index];
        heap[index] = temp;
    }

    public static void printHeap() {
        System.out.println(Arrays.toString(heap));
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(8);
        heap.insert(50);
        heap.insert(30);
        heap.insert(20);
        heap.insert(15);
        heap.insert(10);
        heap.insert(5);
        heap.insert(16);

        heap.printHeap();
        heap.delete(); //50
        System.out.println("remove 50");
        heap.printHeap();

        heap.delete(); //30
        System.out.println("remove 30");
        heap.printHeap();

        heap.delete();//20
        System.out.println("remove 20");
        heap.printHeap();

        heap.delete(); // 16
        System.out.println("remove 16");
        heap.printHeap();

        heap.delete(); //15
        System.out.println("remove 15");

        heap.printHeap();

    }
}
