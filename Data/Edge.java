package Data;
import java.util.ArrayList;
import java.util.List;

public class Edge {
    int vertices;
    List<List<Integer>> list;

    public Edge(int vertices) {
        this.vertices = vertices;
        list = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            list.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        list.get(u).add(v);
        list.get(v).add(u);
    }

    public List<Integer> get(int node) {
        return list.get(node);
    }

    public int size() {
        return vertices;
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for (int neighbor : list.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}