import java.util.*;

class HasPath {
    static class Edge {
        int src;
        int des;
        int wht;

        public Edge(int src, int des, int wht) {
            this.src = src;
            this.des = des;
            this.wht = wht;
        }

    }

    public static boolean hasPath(int curr, ArrayList<Edge>[] graph, boolean[] vis, int dest) {
        if (curr == dest) {
            return true;
        }
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            int desti = graph[curr].get(i).des;
            if (!vis[desti] && hasPath(desti, graph, vis, dest)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 5));

        // vertex 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // vertex 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));
        // vertex 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // vertex 4
        graph[4].add(new Edge(4, 2, 2));
        boolean vis[] = new boolean[graph.length];
        System.out.println(hasPath(0, graph, vis, 5));
    }
}
