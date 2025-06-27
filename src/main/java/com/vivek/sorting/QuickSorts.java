package com.vivek.sorting;

import java.util.Arrays;

public class QuickSorts {
    public static void main(String[] args) {
        int[] inputArray = {50, 50, 60, 90, 40, 80, 10, 20, 50};
        quickSort(inputArray, 0, 8);
        System.out.println(Arrays.toString(inputArray));
    }

    private static int partitions(int[] inputArray, int low, int high) {
        int pivot = inputArray[low];
        int i = low + 1;
        int j = high;
        while (i <= j) {
            while (i <= high && inputArray[i] <= pivot) {
                i++;
            }
            while (j >= low && inputArray[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(inputArray, i, j);
                i++;
                j--;
            }
        }
        swap(inputArray, low, j);
        return j;
    }

    private static void swap(int[] inputArray, int i, int j) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
    }

    public static void quickSort(int[] inputArray, int low, int high) {
        if (low >= high) return;
        int j = partitions(inputArray, low, high);
        quickSort(inputArray, low, j - 1);
        quickSort(inputArray, j + 1, high);
    }
}
