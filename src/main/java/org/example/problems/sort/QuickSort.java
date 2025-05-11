package org.example.problems.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {50, 70, 60, 90, 40, 80, 10, 20};
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }

    }
/*
    public static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int start = low;
        int end = high;
        while (start < end) {
            while (start <= end && array[start] <= pivot) {
                start++;
            }
            while (end >= low && array[end] > pivot) {
                end--;
            }
            if (start < end) {
                swap(array, start, end);
            }
        }
        swap(array, low, end);
        return end;
    }

 */

    private static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int low = left;
        int high = right;
        while (low <= high) {
            if (array[low] <= pivot) {
                low++;
            } else if (array[high] > pivot) {
                high--;
            } else {
                swap(array, low, high);
                low++;
                high--;
            }
        }
        swap(array, left, high);
        return high;
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low > high) return;
        int pivotIndex = partition(array, low, high);
        quickSort(array, low, pivotIndex - 1); //left array
        quickSort(array, pivotIndex + 1, high); //right array

    }

    public static void swap(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}
