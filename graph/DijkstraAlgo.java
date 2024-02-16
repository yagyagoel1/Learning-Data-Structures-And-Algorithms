import java.util.*;


public class DijkstraAlgo {
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
    static class Pair implements Comparable<Pair> {
        int n ;
        int len;
        public Pair(int n,int len){
            this.n=n;
            this.len = len;
        }
    
    @Override
    public int compareTo(Pair p2){
        return this.len- p2.len;
    }
}
    public static void makingPath(ArrayList<Edge>[] graph,int src)
    {
        boolean vis[] = new boolean[graph.length];
        int dis[]=new int[graph.length];
        for(int i=0;i<dis.length;i++)
        {
            if(i!=src)
            dis[i]=Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty())
        {
            Pair curr= pq.remove();
            if(!vis[curr.n])
            vis[curr.n]=true;
            for(int i=0;i<graph[curr.n].size();i++)
            {
                Edge e= graph[curr.n].get(i);
                int u = e.src;
                int wht = e.wht;
                int des = e.des;
                if(dis[u]+wht<dis[des])
                {
                    dis[des] = dis[u]+wht;
                    pq.add(new Pair(des, dis[des]));
                }
            }
        }
        for(int i  =0;i<dis.length;i++)
        {
            System.out.println(dis[i]);
        }
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

        makingPath(graph, 0);
    }
}
