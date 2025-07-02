package com.vivek.graph;

import java.util.*;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        int[][] edge = {{0, 1}, {1, 2}, {2, 3}, {3, 1}, {1, 4}};
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {1, 4}, {2, 3}, {5, 6}, {6, 7}};
        foo(4, edge);

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


    public static int foo(int A, int[][] edges) {
        boolean[] visited = new boolean[A + 1];
        boolean[] currentPath = new boolean[A + 1];
        Arrays.fill(visited, false);
        ArrayList<Integer>[] list = list = adjacencyList(A, edges);
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                boolean result = hasCycle(i, list, visited, currentPath);
                if (result) return 1;

            }
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

}
