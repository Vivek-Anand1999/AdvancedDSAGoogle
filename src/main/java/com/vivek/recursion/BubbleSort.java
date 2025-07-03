package com.vivek.recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1, 4, 3, 2, 7, 5};
        bubbleSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array, int start, int end) {
        if (end == 0) return;
        if (start < end) {
            if (array[start] > array[start + 1]) {
                int temp = array[start];
                array[start] = array[start + 1];
                array[start + 1] = temp;
            }
            bubbleSort(array, start + 1, end);
        } else {
            bubbleSort(array, 0, end - 1);
        }
    }
}
