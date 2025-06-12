package org.example.greedy.problem;

import java.util.Arrays;

public class FractionalKnaSnap {
    public static void main(String[] args) {
        int[] value = {10, 5, 15, 7, 6, 18, 3};
        int[] weight = {2, 3, 5, 7, 1, 4, 1};
        fractionalKnaSnap(value, weight, 15);
    }

    public static void fractionalKnaSnap(int[] value, int[] weight, int capacity) {
        int[][] items = new int[value.length][2];
        for (int i = 0; i < value.length; i++) {
            items[i][0] = value[i]; //[0] -> value
            items[i][1] = weight[i]; //[1] -> weight
        }
        Arrays.sort(items, (a, b) -> { // sort on the basic of weight per 1 unit or 1kg in descending
            double r1 = (double) a[0] / a[1];
            double r2 = (double) b[0] / b[1];
            return Double.compare(r2, r1);
        });
        double maxResult = 0.0;
        int remainingCapacity = capacity;

        for (int[] item : items) {
            int val = item[0];
            int wet = item[1];
            if (wet <= remainingCapacity) {
                maxResult += val;
                remainingCapacity -= wet;
            } else {
                double unitValue = (double) val / wet;
                maxResult += remainingCapacity * unitValue;
                remainingCapacity = 0;
            }
        }
        System.out.println(maxResult);

        for (int[] num : items) {
            System.out.println(Arrays.toString(num));
        }
    }
}
