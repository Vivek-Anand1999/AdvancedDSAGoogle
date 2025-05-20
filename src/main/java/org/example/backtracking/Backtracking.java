package org.example.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        pathFromSourceToDestinations(0, 0, 2, 2, "", result);
        System.out.println(result);
    }

    public static List<List<Character>> generatingAllPermutationsHelper(List<Character> people) {
        List<Character> current = new ArrayList<>();
        List<List<Character>> result = new ArrayList<>();
        generatingAllPermutations(people, current, result);
        return result;
    }

    public static void generatingAllPermutations(List<Character> people, List<Character> current, List<List<Character>> result) {
        if (current.size() == people.size()) {
            if (isValid(current)) {
                result.add(new ArrayList<>(current));
            }
            return;
        }
        for (int i = 0; i < people.size(); i++) {
            if (current.contains(people.get(i))) continue;
            current.add(people.get(i));
            generatingAllPermutations(people, current, result);
            current.removeLast(); // always remove from last
        }
    }

    public static boolean isValid(List<Character> current) {
        for (int i = 1; i < current.size() - 1; i++) {
            if (current.get(i) == 'C' && current.get(i - 1) != 'C' && current.get(i + 1) != 'C') {
                return false;
            }
        }
        return true;
    }

    public static List<String> parenthesisHelper(int input) {
        List<String> result = new ArrayList<>();
        String current = "";
        parenthesis(input, current, 0, 0, result);
        return result;
    }

    public static void parenthesis(int n, String current, int open, int close, List<String> result) {
        if (open + close == n) {
            result.add(current);
            return;
        }
        if (open < n / 2) {
            parenthesis(n, current + "(", open + 1, close, result);
        }
        if (open > close) {
            parenthesis(n, current + ")", open, close + 1, result);
        }
    }

    public static void helper() {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        setCombination(new int[]{1, 2, 3, 4, 5}, 0, current, result);
        System.out.println(result);
    }

    public static void setCombination(int[] array, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == array.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(array[index]);
        setCombination(array, index + 1, current, result);
        current.removeLast();
        setCombination(array, index + 1, current, result);
    }

    public static void allPermutationsHelpers() {
        String str = "ABC";
        boolean[] used = new boolean[str.length()];
        List<Character> current = new ArrayList<>();
        List<List<Character>> result = new ArrayList<>();
        allPermutations(str, current, result, used);
        System.out.println(result);
    }

    public static void allPermutations(String str, List<Character> current, List<List<Character>> result, boolean[] used) {
        if (current.size() == str.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (used[i] == false) {
                current.add(str.charAt(i));
                used[i] = true;
                allPermutations(str, current, result, used);
                current.removeLast();
                used[i] = false;
            }
        }
    }

    public static void helperStairCase() {
        List<Integer> result = new ArrayList<>();
        printPathStairCase(0, 0, result);

    }

    private static void printPathStairCase(int index, int inputSize, List<Integer> result) {
        if (index == inputSize) {
            System.out.println(result);
            return;
        }
        if (index > inputSize) {
            return;
        }
        result.add((1));
        printPathStairCase(index + 1, inputSize, result);
        result.removeLast();
        result.add(2);
        printPathStairCase(index + 2, inputSize, result);
        result.removeLast();
    }

    public static void pathFromSourceToDestinations(int sr, int sc, int dr, int dc, String current, List<String> result) {
        if (sr == dr && sc == dc) {
            result.add(current);
            return;
        }
        if (sr < dr) {
            pathFromSourceToDestinations(sr + 1, sc, dr, dc, current + "D", result);
        }
        if (sc < dc) {
            pathFromSourceToDestinations(sr, sc + 1, dr, dc, current + "R", result);
        }
    }

}
