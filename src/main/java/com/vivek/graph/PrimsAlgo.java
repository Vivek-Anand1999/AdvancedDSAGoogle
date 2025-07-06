package com.vivek.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimsAlgo {
    public static void main(String[] args) {
        int[][] edges = {{1, 2, 7}, {1, 4, 8}, {2, 3, 6}, {2, 4, 3}, {2, 3, 8}, {2, 1, 7}, {3, 4, 2},
                {3, 5, 2}, {3, 6, 5}, {3, 2, 6}, {3, 2, 8}, {4, 1, 8}, {4, 3, 4}, {4, 5, 3}, {4, 2, 3},
                {5, 3, 2}, {5, 4, 3}, {5, 6, 5}, {6, 3, 5}, {6, 5, 5}};
        int[][] array = {{1, 2, 14}, {2, 3, 7}, {3, 1, 2}};
        System.out.println(minimumCostSpinningTree(array, 3));
    }

    private static ArrayList<pairs>[] adjacencyList(int n, int[][] edges) {
        ArrayList<pairs>[] adjacencyList = new ArrayList[n + 1];
        for (int initializationOfArray = 0; initializationOfArray < adjacencyList.length; initializationOfArray++) {
            adjacencyList[initializationOfArray] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int firstVertex = edge[0];
            int secondVertex = edge[1];
            int weight = edge[2];
            adjacencyList[firstVertex].add(new pairs(secondVertex, weight));
            adjacencyList[secondVertex].add(new pairs(firstVertex, weight));
        }
        System.out.println(Arrays.deepToString(adjacencyList));
        return adjacencyList;
    }

    public static int minimumCostSpinningTree(int[][] edges, int n) {
        ArrayList<pairs>[] adjacencyList = adjacencyList(n, edges);
        boolean[] visited = new boolean[n + 1];
        Queue<pairs> minheap = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        int vertex = edges[0][0];
        int ans = 0;
        for (int creatingEdge = 0; creatingEdge < adjacencyList.length - 1; creatingEdge++) {
            visited[vertex] = true;
            minheap.addAll(adjacencyList[vertex]);
            while (!minheap.isEmpty()) {
                pairs temp = minheap.poll();
                if (!visited[temp.neighbour]) {
                    ans += temp.weight;
                    vertex = temp.neighbour;
                    break;
                }
            }
        }
        return ans;
    }
}

class pairs {
    int neighbour;
    int weight;

    pairs(int neighbour, int weight) {
        this.neighbour = neighbour;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + neighbour + " " + weight + ")";
    }
}