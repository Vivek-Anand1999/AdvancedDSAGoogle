package com.vivek.sorting;

import java.util.Arrays;

public class MergeSorts {
    public static void main(String[] args) {
        int[] inputArray = {8, 2, 9, 6, 5, 3, 7, 4, 1};
        foo(inputArray, 0, inputArray.length - 1);
        System.out.println(Arrays.toString(inputArray));

    }

    public static void mergeSort(int[] inputArray) {
        int pass = 0;
        int i = 0;
        int[] mergedArray = new int[inputArray.length];
        for (pass = 2; pass <= inputArray.length; pass *= 2) {
            for (i = 0; pass - 1 + i < inputArray.length; i += pass) {
                int low = i;
                int high = pass - 1 + i;
                int mid = (low + high) / 2;
                merge(inputArray, low, mid, high, mergedArray);
            }
            while (i < inputArray.length) {
                mergedArray[i] = inputArray[i++];
            }
            System.arraycopy(mergedArray, 0, inputArray, 0, inputArray.length);
        }
        if (pass / 2 < inputArray.length) {
            int low = 0;
            int high = inputArray.length - 1;
            int mid = pass / 2 - 1;
            merge(inputArray, low, mid, high, mergedArray);
            System.arraycopy(mergedArray, 0, inputArray, 0, inputArray.length);
        }
        System.out.println(Arrays.toString(mergedArray));
    }

    public static void merge(int[] inputArray, int low, int mid, int high, int[] mergedArray) {
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (inputArray[i] < inputArray[j]) {
                mergedArray[k++] = inputArray[i++];
            } else {
                mergedArray[k++] = inputArray[j++];
            }
        }
        while (i <= mid) {
            mergedArray[k++] = inputArray[i++];
        }
        while (j <= high) {
            mergedArray[k++] = inputArray[j++];
        }

    }

    public static void foo(int[] A, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;
        foo(A, low, mid);
        foo(A, mid + 1, high);
        merg(A, low, mid, high);
    }

    private static void merg(int[] A, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] tempArray = new int[high - low + 1];
        while (i <= mid && j <= high) {
            if (A[i] < A[j]) {
                tempArray[k++] = A[i++];
            } else {
                tempArray[k++] = A[j++];
            }
        }
        while (i <= mid) {
            tempArray[k++] = A[i++];
        }
        while (j <= high) {
            tempArray[k++] = A[j++];
        }

        for (i = 0; i < tempArray.length; i++) {
            A[low++] = tempArray[i];
        }
    }
}
