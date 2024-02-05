import java.util.*;

class Bfs {
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
    public static void bfs(ArrayList<Edge>[] graph)
    {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);
        while(!q.isEmpty())
        {
            int curr = q.remove();
          
            if(!vis[curr])
            {
                System.out.print(curr +" ");
                vis[curr] =true;
                for(int i=0 ;i<graph[curr].size();i++)
                {
            
                    q.add(graph[curr].get(i).des);
                }
            }
        }
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

        //vertex 4 
        graph[4].add(new Edge(4,2 ,2 ));

        bfs(graph);
    }
}