package com.vivek.graph;

import java.util.*;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        int[][] edge = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(foo(5, edge));
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

    public static void recurse(int depth) {
        System.out.println("Recursion depth: " + depth);
        recurse(depth + 1);
    }

    public static int foo(int A, int[][] edges) {
        boolean[] visited = new boolean[A + 1];
        Arrays.fill(visited, false);
        ArrayList<Integer>[] list = new ArrayList[A + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            list[u].add(v);
        }

        boolean result = hasCycle(edges[0][0], list, visited);
        if (result) {
            return 1;
        } else {
            return 0;
        }


    }

    public static boolean hasCycle(int vertex, ArrayList<Integer>[] edges, boolean[] visited) {
        visited[vertex] = true;
        for (int i = 0; i < edges[vertex].size(); i++) {
            int adjacentVertex = edges[vertex].get(i);
            if (visited[adjacentVertex]) {
                return true;
            }
            return hasCycle(adjacentVertex, edges, visited);
        }
        return false;
    }


}
