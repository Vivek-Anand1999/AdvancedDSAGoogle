package com.vivek.problems.amazon;

import java.util.HashMap;
import java.util.Map;

public class Sequence {
    public static void main(String[] args) {
        System.out.println(foo(4));

    }
    public static int foo(int n){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(2,4);
        map.put(3,9);
        if(map.containsKey(n)) return map.get(n);
        int count = 0;
        while(!map.containsKey(n)){
            count++;
            n -= 4;
        }
        return map.get(n)+(count*10);
    }
}
