package org.example.problems;

public class SubArray {
    public static void main(String[] args) {
        subArraySum(new int[]{1, 2, 3, 4});

    }

    public static void subArraySum(int[] inputArray) {
        int[] prefixSum = new int[inputArray.length];

        for (int arrayIndex = 0; arrayIndex < inputArray.length; arrayIndex++) {
            prefixSum[arrayIndex] = arrayIndex == 0 ? inputArray[arrayIndex] : prefixSum[arrayIndex - 1] + inputArray[arrayIndex];
        }

        int result = 0;
        for (int start = 0; start < inputArray.length; start++) {
            int sum = 0;
            int carry = 0;
            for (int end = start; end < inputArray.length; end++) {
                sum += inputArray[end];
                carry += sum;
            }
            result += carry;
        }
        System.out.println(result);
    }
}
