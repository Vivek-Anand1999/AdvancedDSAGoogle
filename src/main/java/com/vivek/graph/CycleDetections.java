package com.vivek.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class CycleDetections {
    public static void main(String[] args) {
        int[][] array = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 1}};
        int x = foo(5, array);
        System.out.println(x);
    }

    private static boolean hasCycle(int vertex, ArrayList<Integer>[] edges, boolean[] visited) {
        if (visited[vertex]) {
            return true;
        }
        visited[vertex] = true;
        for (int i = 0; i < edges[vertex].size(); i++) {
            int adj = edges[vertex].get(i);
            return hasCycle(adj, edges, visited);
        }
        return false;

    }

    public static int foo(int A, int[][] edges) {
        boolean[] visited = new boolean[A + 1];
        Arrays.fill(visited, false);
        ArrayList<Integer>[] adjacencyList = new ArrayList[A + 1]; // we are declaring an int of arraylist
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList[u].add(v);
        }
        boolean result = hasCycle(edges[0][0], adjacencyList, visited);
        if (result) {
            return 1;
        }
        return 0;
    }
}
