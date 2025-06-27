package com.vivek.problems.amazon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String target = "ABC";
        System.out.println(foo(str,target));
    }

    public static void foo(int idx, int[]array, List<Integer> current,List<List<Integer>> result){
        if(array[idx] < array[idx+1]){
            current.add(array[idx]);
            foo(idx+1, array,current,result);
        }else{
            foo(idx+2, array,current,result);
        }
    }

    public static String foo(String str,String tar){
        Map<Character,Integer>window = new HashMap<>();
        Map<Character,Integer>target = new HashMap<>();
        for(int i = 0; i < tar.length(); i++){
            target.put(tar.charAt(i),target.getOrDefault(tar.charAt(i),0)+1);
        }
        int i = 0;
        int j =0;
        String s1 = " ";
        int formed = 0;
        int minLength = Integer.MAX_VALUE;
        while(j < str.length()){
            char c = str.charAt(j);
            window.put(c,window.getOrDefault(c,0)+1);
            if(target.containsKey(c) &&  target.get(c) >= window.get(c)){
                formed++;
            }
            while(formed == tar.length()){
                String s = str.substring(i,j+1);
                if(minLength > s.length()){
                    minLength = s.length();
                    s1 = s;
                }
                char removeChar = str.charAt(i);
                window.put(removeChar,window.getOrDefault(removeChar,0)-1);
                if(target.containsKey(removeChar)&& window.get(removeChar)< target.get(removeChar)){
                    formed--;
                }
                i++;
            }
            j++;
        }
        return s1;
    }
}
