package com.vivek.arrays;

import java.util.Arrays;

public class Diagonal {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        transposeRectangle(array);
//        System.out.println(Arrays.deepToString(array));
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
}
