package com.vivek.problems.amazon;

public class RepeatString {
    public static void main(String[] args) {
        System.out.println(foo("input",5));
    }
    public static String foo(String s, int n){
        String substring = s.substring(0, n);
        return substring.repeat(n);
    }
}
