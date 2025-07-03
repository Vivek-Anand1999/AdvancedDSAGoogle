package com.vivek.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 3, 3, 2, 2, 7, 6};
        int i = recursionHelper(array, 1, 9);
        System.out.println(i);

    }

    public static void BFS(int[][] edges) {
        int[][] matric = new int[7][7];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            matric[u][v] = 1;
            matric[v][u] = 1;
        }

        boolean[] visited = new boolean[7];
        Arrays.fill(visited, false);
        dfsIterative(edges[0][0], matric, visited);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(edges[0][1]);
        int x = edges[0][1];
        visited[x] = true;
        System.out.print(queue.peek() + " ");
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int vertex = 1; vertex < 7; vertex++) {
                if (!visited[vertex] && matric[u][vertex] == 1) {
                    System.out.print(vertex + " ");
                    queue.add(vertex);
                    visited[vertex] = true;
                }
            }
        }
        System.out.println(Arrays.toString(visited));

    }

    private static void dfs(int vertex, int[][] edges, boolean[] visited) {
        System.out.println(vertex + " ");
        visited[vertex] = true;
        for (int i = 1; i < 7; i++) {
            if (!visited[i] && edges[vertex][i] == 1) {
                dfs(i, edges, visited);
            }
        }
    }

    public static void dfsIterative(int vertex, int[][] edges, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        System.out.println(vertex + " ");
        visited[vertex] = true;
        stack.push(vertex);
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            if (!visited[temp]) {
                visited[temp] = true;
                System.out.println(temp + " ");
            }
            for (int i = 1; i < 7; i++) {
                if (!visited[i] && edges[temp][i] == 1) {
                    stack.push(i);
                }
            }
        }
    }


    public static int recursionHelper(int A, int[][] edges) {
        boolean[] visited = new boolean[A + 1];
        boolean[] currentPath = new boolean[A + 1];
        Arrays.fill(visited, false);
        ArrayList<Integer>[] list = list = adjacencyList(A, edges);
        boolean result = hasPath(1, 5, visited, list);
        if (result) {
            return 1;
        }
        return 0;

    }

    public static boolean hasCycle(int vertex, ArrayList<Integer>[] edges, boolean[] visited, boolean[] currentPath) {
        if (currentPath[vertex]) return true;
        currentPath[vertex] = true;
        visited[vertex] = true;
        for (int i = 0; i < edges[vertex].size(); i++) {
            int adjacentVertex = edges[vertex].get(i);
            if (currentPath[adjacentVertex]) return true;
            if (!visited[adjacentVertex]) {
                if (hasCycle(adjacentVertex, edges, visited, currentPath)) return true;
            }
        }
        currentPath[vertex] = false;
        return false;
    }


    public static void helper(int max, int[][] edges) {
        ArrayList<Integer>[] list = adjacencyList(max, edges);
        int vertex = edges[0][0];
        boolean[] visited = new boolean[max + 1];
        Arrays.fill(visited, false);
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfsGraph(i, list, visited);
            }
        }
    }

    public static void dfsGraph(int vertex, ArrayList<Integer>[] lists, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int adjacentVertex : lists[vertex]) {
            if (!visited[adjacentVertex]) {
                dfsGraph(adjacentVertex, lists, visited);
            }
        }
    }

    private static ArrayList<Integer>[] adjacencyList(int max, int[][] edges) {
        ArrayList<Integer>[] list = new ArrayList[max + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            list[u].add(v);
        }

        System.out.println(Arrays.deepToString(list));
        return list;
    }

    public static boolean hasPath(int vertex, int target, boolean[] visited, ArrayList<Integer>[] adjacencyList) {
        if (vertex == target) return true;
        visited[vertex] = true;
        for (int adjacentVertex : adjacencyList[vertex]) {
            if (!visited[adjacentVertex]) {
                if (hasPath(adjacentVertex, target, visited, adjacencyList)) return true;
            }
        }
        return false;
    }

    public static int recursionHelper(int[] array, int source, int destination) {
        boolean[] visited = new boolean[array.length + 1];
        Arrays.fill(visited, false);
        ArrayList<Integer>[] adjacencyList = adjacencyList(array);
        boolean result = hasFDFS(source, destination, adjacencyList, visited);
        if (result) {
            return 1;
        }
        return 0;
    }

    private static boolean hasFDFS(int vertex, int destination, ArrayList<Integer>[] list, boolean[] visited) {
        if (vertex == destination) {
            return true;
        }
        visited[vertex] = true;
        for (int adjacencyVertex : list[vertex]) {
            if (!visited[adjacencyVertex]) {
                if (hasFDFS(adjacencyVertex, destination, list, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static ArrayList<Integer>[] adjacencyList(int[] A) {
        ArrayList<Integer>[] list = new ArrayList[A.length + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < A.length; i++) {
            list[A[i]].add(i + 1);
        }
        return list;
    }

}
