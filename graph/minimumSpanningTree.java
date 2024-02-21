import java.util.*;


public class minimumSpanningTree {
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
   static class Pair implements Comparable<Pair>{
        int v;
        int cost;
        public Pair(int v,int cost)
        {
            this.v = v;
            this.cost= cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }
    public static void prim(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int cost = 0;
        while(!pq.isEmpty())
        {
            Pair curr=pq.remove();
            if(!vis[curr.v])
            {
                vis[curr.v]=true;
                cost +=curr.cost;
                for(int i = 0;i<graph[curr.v].size();i++)
                {
                    Edge e = graph[curr.v].get(i); 
                    pq.add(new Pair(e.des,e.wht ));

                }
            } 
        }
        System.out.println("minimum cost "+cost);
    }
    public static void main(String args[]) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1,3 , 7));
        graph[1].add(new Edge(1, 2, 1));


        graph[2].add(new Edge(2, 4, 3));

     
        graph[3].add(new Edge(3, 5, 1));
       


        
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        prim(graph);
    }
}
