package com.vivek.subSequence;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubSequenceTest {

    @Test
    void printSubSequence() {
        int[] array = {1, 2};
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        SubSequence.printSubSequence(0, array, current, result);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList()
        );

        assertTrue(result.containsAll(expected) && expected.containsAll(result),
                "Subsequences don't match expected output");
    }

    @Test
    void check() {
    }
}