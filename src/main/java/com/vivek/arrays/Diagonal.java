package com.vivek.arrays;

public class Diagonal {
    public static void main(String[] args) {
        int[][] array = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 } };
        allDiagonal(array);
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
        for (int i = 0; i < array[0].length; i++) {
            int row = 0;
            int col = i;
            while (row < array.length && col >= 0) {
                System.out.print(array[row][col] + " ");
                row++;
                col--;
            }
            System.out.println();
        }
        // printing all diagonal start from the row = 1
        for (int i = 1; i < array.length; i++) {
            int row = i;
            int col = array[0].length - 1;
            while (row < array.length && col >= 0) {
                System.out.print(array[row][col] + " ");
                row++;
                col--;
            }
            System.out.println();
        }
    }
}
