package com.vivek.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    ArrayList<Integer> heap = new ArrayList<>();

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(5, 13, -2, 11, 27, 31, 0, 19));
        MinHeap minHeap = new MinHeap();
        System.out.println(list);
        minHeap.createHeap((ArrayList<Integer>) list);
        System.out.println(list);
    }

    public void insert(int value) {
        heap.add(value);
        int index = heap.size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(parentIndex) > heap.get(index)) {
                swap(index, parentIndex, heap);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public void remove() {
        int removedValue = heap.get(heap.size() - 1);
        heap.set(0, removedValue);
        heap.removeLast();
//        heapify(0);
    }

    private void swap(int index, int parentIndex, ArrayList<Integer> heap) { // i need index
        int temp = heap.get(index);
        heap.set(index, heap.get(parentIndex));
        heap.set(parentIndex, temp);
    }

    private void heapify(int index, ArrayList<Integer> heap) {
        while (index < heap.size()) {
            int minIndex = index;
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;
            if (leftChildIndex < heap.size() && heap.get(leftChildIndex) < heap.get(minIndex)) {
                minIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)) {
                minIndex = rightChildIndex;
            }
            if (minIndex != index) {
                swap(minIndex, index, heap);
                index = minIndex;
            } else {
                break;
            }
        }
    }

    // from array create heap in o(n)
    public void createHeap(ArrayList<Integer> heap) {
        int i = (heap.size() - 2) / 2;
        for (; i >= 0; i--) {
            heapify(i, heap);
        }
    }

    public void printHeap() {
        System.out.println(heap);
    }

}
