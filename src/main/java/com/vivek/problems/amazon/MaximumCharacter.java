package com.vivek.problems.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumCharacter {
    public static void main(String[] args) {
        minimumCharacter("anand");

    }
    public static char foo(String s){
        if(s == null || s.length() == 0)return ' ';
        if(s.length() == 1)return s.charAt(0);
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0 ; i < s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        char result = ' ';
        int ref = 0;

        for(int i = 0; i  < s.length(); i++){
            if(ref < map.get(s.charAt(i))){
                result = s.charAt(i);
                ref = map.get(s.charAt(i));
            }
        }
        if(ref == 0){
            return s.charAt(0);
        }else{
            return result;
        }
    }

    public static void minimumCharacter(String s){
        int[]charIndex = new int[26];
        for(int i = 0; i < s.length(); i++){
            charIndex[s.charAt(i)-'a']++;
        }
        int ans = 0;
        int index = 0;
        for(int i = 0; i < 26; i++){
            if(charIndex[i] > ans){
                ans = charIndex[i];
                index = i;
            }
        }
        if(index == 0){
            System.out.println(s.charAt(0));
        }else{
            System.out.println((char) (index+ 'a'));
        }
        System.out.println(Arrays.toString(charIndex));
    }
}
