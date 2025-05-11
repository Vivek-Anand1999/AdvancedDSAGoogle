package org.example.comparable.comparators;

import java.util.Arrays;
import java.util.Comparator;

public class Comparators {
    public static void main(String[] args) {
        Integer[] array = {1, 6, 2};
        Arrays.sort(array, new comparator());
        System.out.println(Arrays.toString(array));

    }

}

class comparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        System.out.println(o1 + " " + o2);
        return 0;
    }
}