package com.vivek.greedy.problems;

import java.util.ArrayList;

public class Seats {
    public static void main(String[] args) {
        String  A = "....x..xx...x..";
        System.out.println(foo(A));
    }

    public static int minSeat(String str){
        int[]seatPosition = new int[3];
        int index = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)=='x'){
                seatPosition[index++] = i;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < seatPosition.length; i++){
            int sum =0;
            int left = leftExpand(seatPosition,i);
            int right = rightExpand(seatPosition,i);
            sum = left+right;
            min = Math.min(min,sum);
        }
        return min;
    }
    public static int leftExpand(int[]array, int index){
        int sum = 0;
        int step = 0;
        for(int i = index-1; i >= 0; i--){
            sum += array[index]-array[i]-step-1;
            step++;
        }
        return sum;
    }

    public static int rightExpand(int[]array, int index){
        int sum = 0;
        int step = 0;
        for(int i = index+1; i < array.length; i++){
            sum += array[i]-array[index]-step-1;
            step++;
        }
        return sum;
    }
    public static int foo(String str){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'x'){
                list.add(i);
            }
        }

        int minSum = 0;
        int midIndex = list.size()/2;
        int median = list.get(midIndex);

        for(int i = 0; i < list.size(); i++ ){
            minSum += Math.abs((median - midIndex) - list.get(i)+i);
        }

        return minSum;
    }
}
