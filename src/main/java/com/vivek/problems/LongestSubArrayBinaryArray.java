package com.vivek.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayBinaryArray {
    public static void main(String[] args) {
        int[] array = { 2, 2, 6, 4, 5, 1, 5, 2, 6, 4, 1 };
        System.out.println(minLength(array));
    }

    public static int longestSubArray(int[] array) {
        int maxLength = 0;
        Map<Integer, Integer> firstSeen = new HashMap<>(); // <Sum, Index>
        for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
            if (array[arrayIndex] == 0) {
                array[arrayIndex] = -1;
            }
            array[arrayIndex] = arrayIndex == 0 ? array[arrayIndex] : array[arrayIndex - 1] + array[arrayIndex];
            if (array[arrayIndex] == 0) {
                maxLength = arrayIndex + 1;
            }
            if (firstSeen.containsKey(array[arrayIndex])) {
                maxLength = Math.max(maxLength, (arrayIndex - firstSeen.get(array[arrayIndex])));
            } else {
                firstSeen.put(array[arrayIndex], arrayIndex);
            }
        }
        System.out.println(Arrays.toString(array));
        return maxLength;
    }

    public static int specialIndex(int[] array) {
        int[] evenPrefixSum = new int[array.length];
        int[] oddPrefixSum = new int[array.length];
        for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
            evenPrefixSum[arrayIndex] = arrayIndex == 0 ? array[arrayIndex]
                    : arrayIndex % 2 == 0 ? evenPrefixSum[arrayIndex - 1] + array[arrayIndex]
                            : evenPrefixSum[arrayIndex - 1];
            oddPrefixSum[arrayIndex] = arrayIndex == 0 ? 0
                    : arrayIndex % 2 != 0 ? oddPrefixSum[arrayIndex - 1] + array[arrayIndex]
                            : oddPrefixSum[arrayIndex - 1];
        }

        System.out.println(Arrays.toString(evenPrefixSum));
        System.out.println(Arrays.toString(oddPrefixSum));

        int count = getCount(array, oddPrefixSum, evenPrefixSum);
        return count;
    }

    private static int getCount(int[] array, int[] oddPrefixSum, int[] evenPrefixSum) {
        int count = 0;
        for (int specialIndex = 0; specialIndex < array.length; specialIndex++) {
            int even = 0;
            int odd = 0;
            if (specialIndex == 0) {
                even = evenPrefixSum[array.length - 1] - evenPrefixSum[specialIndex];
                odd = oddPrefixSum[array.length - 1] - oddPrefixSum[specialIndex];
            } else {
                even = evenPrefixSum[specialIndex - 1] + (oddPrefixSum[array.length - 1] - oddPrefixSum[specialIndex]);
                odd = oddPrefixSum[specialIndex - 1] + (evenPrefixSum[array.length - 1] - evenPrefixSum[specialIndex]);
            }
            if (even == odd) {
                count++;
            }
        }
        return count;
    }

    public static int minLength(int[] array) {
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            minElement = Math.min(minElement, array[i]);
            maxElement = Math.max(maxElement, array[i]);
        }
        if (minElement == maxElement)
            return 1;
        int minIndex = -1;
        int maxIndex = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == minElement) {
                minIndex = i;
                if (maxIndex != -1) {
                    ans = Math.min(ans, (i - maxIndex + 1));
                }
            } else if (array[i] == maxElement) {
                maxIndex = i;
                if (minIndex != -1) {
                    ans = Math.min(ans, (i - minIndex + 1));
                }
            }
        }
        return ans;
    }
}
