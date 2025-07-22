package com.vivek.arrays;

import java.util.Arrays;

public class Diagonal {

    public static void main(String[] args) {
        String s = "anmaddamm";
        System.out.println(longestPalindromeString(s));
    }

    public static void diagonal(int[][] array) {
        int row = 0;
        int col = 0;
        while (row < array.length && col < array[0].length) {
            System.out.println(array[row][col] + " ");
            row++;
            col++;
        }
    }

    public static void antiDiagonal(int[][] array) {
        int row = 0;
        int col = array[0].length - 1;
        while (row < array.length && col >= 0) {
            System.out.println(array[row][col]);
            row++;
            col--;
        }
    }

    public static void allDiagonal(int[][] array) {
        // printing all diagonal start from the row = 0
        int[][] result = new int[(array.length + array[0].length) - 1][array[0].length - 1];
        int resultRow = 0;
        for (int i = 0; i < array[0].length; i++) {
            int row = 0;
            int col = i;
            int index = 0;
            while (row < array.length && col >= 0) {
                result[resultRow][index] = array[row][col];
                row++;
                col--;
                index++;
            }
            resultRow++;
        }
        // printing all diagonal start from the row = 1
        for (int i = 1; i < array.length; i++) {
            int row = i;
            int col = array[0].length - 1;
            int index = 0;
            while (row < array.length && col >= 0) {
                result[resultRow][index] = array[row][col];
                row++;
                col--;
                index++;
            }
            resultRow++;
        }

        System.out.println(Arrays.deepToString(result));

    }

    public static void transpose(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array[0].length; j++) {
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }
    }

    public static void transposeRectangle(int[][] array) {
        int[][] result = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                result[j][i] = array[i][j];
            }
        }
        System.out.println(Arrays.deepToString(result));
    }

    public static void rotateMatrix90(int[][] array) {
        // transpose
        for (int row = 0; row < array.length; row++) {
            for (int col = row + 1; col < array[0].length; col++) {
                int temp = array[row][col];
                array[row][col] = array[col][row];
                array[col][row] = temp;
            }
        }
        // swap
        for (int row = 0; row < array.length; row++) {
            int start = 0;
            int end = array[row].length - 1;
            while (start < end) {
                int temp = array[row][start];
                array[row][start] = array[row][end];
                array[row][end] = temp;
                start++;
                end--;
            }
        }
    }

    public static void rotate270(int[][] array) {
        // transpose
        for (int row = 0; row < array.length; row++) {
            for (int col = row + 1; col < array[0].length; col++) {
                int temp = array[row][col];
                array[row][col] = array[col][row];
                array[col][row] = temp;
            }
        }
        // swapping
        for (int col = 0; col < array[0].length; col++) {
            int start = 0;
            int end = array.length - 1;
            while (start < end) {
                int temp = array[start][col];
                array[start][col] = array[end][col];
                array[end][col] = temp;
                start++;
                end--;
            }
        }
    }

    // Bit Mnaupulations
    public static int convertToDecimal(int n) {
        int pow = 1;
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            n = n / 10;
            ans = ans + (rem * pow);
            pow *= 2;
        }
        return ans;

    }

    public static int convertToDecimalRec(int n, int pow) {
        if (n == 0)
            return 0;
        int rem = n % 10;
        int ans = rem * pow;
        return ans + convertToDecimalRec(n / 10, pow * 2);

    }

    public static int convertToBinaryRec(int n, int pow) {
        if (n == 0)
            return 0;
        int rem = n % 2;
        int ans = rem * pow;
        return ans + convertToBinaryRec(n / 2, pow * 10);

    }

    public static int binaryAdd(int n1, int n2) {
        int carry = 0;
        int pow = 1;
        int ans = 0;
        while (n1 != 0 || n2 != 0 || carry != 0) { // TC = o(log10(Max(n1,n2)))
            int n1Rem = n1 % 10;
            int n2Rem = n2 % 10;
            n1 = n1 / 10;
            n2 = n2 / 10;
            int sum = n1Rem + n2Rem + carry;
            int rem = sum % 2;
            carry = sum / 2;
            ans = ans + (rem * pow);
            pow *= 10;
        }
        return ans;
    }

    public static int binaryAddRec(int n1, int n2, int carry, int pow) {
        if (n1 == 0 && n2 == 0 && carry == 0)
            return 0;
        int n1Rem = n1 % 10;
        int n2Rem = n2 % 10;
        int sum = n1Rem + n2Rem + carry;
        int rem = sum % 2;
        int ans = rem * pow;
        ans = ans + binaryAddRec(n1 / 10, n2 / 10, sum / 2, pow * 10);
        return ans;

    }

    public static int longestPalindromeString(String s) {
        if (s.length() == 0)
            return 0;
        int ans = 1;
        for (int index = 1; index < s.length(); index++) {
            int oddLength = oddLength(s, index);
            int evenLength = evenLength(s, index);
            ans = Math.max(ans, Math.max(oddLength, evenLength));
        }
        return ans;
    }

    private static int oddLength(String s, int index) {
        int l = index - 1;
        int r = index + 1;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            } else {
                break;
            }
        }
        return r - l - 1;
    }

    private static int evenLength(String s, int index) {
        int l = index;
        int r = index + 1;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            } else {
                break;
            }
        }
        return r - l - 1;
    }
}
