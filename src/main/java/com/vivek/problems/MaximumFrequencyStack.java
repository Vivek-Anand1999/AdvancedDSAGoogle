package com.vivek.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {
    public static ArrayList<Integer> foo(ArrayList<ArrayList<Integer>> array) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Stack<Integer>> frequentStack = new HashMap<>();
        int maxFreq = 0;
        for (ArrayList<Integer> num : array) {
            if (num.get(0) == 1) {
                int val = num.get(1);
                freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
                int freq = freqMap.get(val);
                frequentStack.putIfAbsent(freq, new Stack<>());
                frequentStack.get(freq).push(val);
                if (freq > maxFreq) {
                    maxFreq = freq;
                }
                result.add(-1);
            } else {
                int tem = frequentStack.get(maxFreq).pop();
                freqMap.put(tem, freqMap.get(tem) - 1);
                if (frequentStack.get(maxFreq).isEmpty()) {
                    maxFreq--;
                }
                result.add(tem);
            }
        }
        return result;
    }
}
