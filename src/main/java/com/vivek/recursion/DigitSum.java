package com.vivek.recursion;

public class DigitSum {
    public static int sum = 0;

    public static void main(String[] args) {
        pattern(4, 0);
    }

    static int sum(int digit) {
        if (digit == 0) return 0;
        int x = digit % 10;
        return x + sum(digit / 10);
    }

    static void reverse(int digit) {
        if (digit == 0) return;
        int rem = digit % 10;
        sum = sum * 10 + rem;
        reverse(digit / 10);
    }

    public static void helper(int digit) {
        int pow = (int) Math.log10(digit) + 1;
        int i = reverse1(digit, 10, pow - 1);
        System.out.println(i);
    }

    public static int reverse1(int digit, int base, int pow) {
        if (digit == 0) return 0;
        if (pow == 0) return digit;
        return (digit % 10) * (int) Math.pow(base, pow) + reverse1(digit / 10, base, pow - 1);
    }

    public static int solve(int num, int count) {
        if (num == 0) return count;
        if (num % 2 == 0) {
            return solve(num / 2, count + 1);
        } else {
            return solve(num - 1, count + 1);
        }
    }

    public static boolean isSorted(int[] array, int index) {
        if (index == array.length - 1) return true;
        return array[index] < array[index + 1] && isSorted(array, index + 1);
    }

    public static boolean isFound(int[] array, int index, int target) {
        if (index == array.length) return false;
        if (array[index] == target) return true;
        return isFound(array, index + 1, target);
    }

    public static boolean find(int[] array, int index, int target) {
        if (index == array.length) return false;
        return array[index] == target || find(array, index + 1, target);
    }

    public static int rotateBinarySearch(int[] array, int s, int e, int target) {
        int mid = s + (e - s) / 2;
        if (s > e) {
            return -1;
        }
        if (array[mid] == target) return mid;
        if (array[s] <= array[mid]) {
            if (target >= array[s] && target <= array[mid]) {
                return rotateBinarySearch(array, s, mid - 1, target);
            } else {
                return rotateBinarySearch(array, mid + 1, e, target);
            }
        }
        if (target >= array[mid] && target <= array[e]) {
            return rotateBinarySearch(array, mid + 1, e, target);
        } else {
            return rotateBinarySearch(array, s, mid - 1, target);
        }

    }

    public static void pattern(int row, int col) {
        if (row == 0) return;
        if (row > col) {
            pattern(row, col + 1);
            System.out.print("* ");
        } else {
            pattern(row - 1, 0);
            System.out.println();
        }
    }
}
