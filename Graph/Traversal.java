package graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import data.Edge;

public class Traversal {
    public static void main(String[] args) {
        Edge graph = new Edge(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);

        graph.addEdge(1, 3);

        graph.addEdge(2, 3);
        graph.addEdge(2, 4);

        graph.addEdge(3, 4);

        List<Integer> dfsRes = new ArrayList<>();
        dfs(graph, 0, new boolean[5], dfsRes);
        System.out.println(dfsRes);
        bfs(graph, 0);
    }

    public static void dfs(Edge graph, int node, boolean[] vis, List<Integer> res) {
        res.add(node);
        vis[node] = true;

        for (int neigh : graph.get(node)) {
            if (!vis[neigh]) {
                dfs(graph, neigh, vis, res);
            }
        }
    }

    public static void bfs(Edge graph, int node) {
        boolean[] vis = new boolean[graph.size()];
        List<Integer> res = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        vis[node] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            for (int neigh : graph.get(curr)) {
                if (!vis[neigh]) {
                    vis[neigh] = true;
                    q.offer(neigh);
                }
            }
        }

        System.out.println(res);
    }
}