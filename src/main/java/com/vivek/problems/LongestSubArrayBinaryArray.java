package com.vivek.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayBinaryArray {
    public static void main(String[] args) {
        int[] binaryArray = {0, 1, 0, 1, 0, 1};
        System.out.println(longestSubArray(binaryArray));
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
}
