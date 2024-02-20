import java.util.*;


public class BellmanFordAlgo {
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


    public static void makingPath(ArrayList<Edge>[] graph,int src)
    {
        boolean vis[] = new boolean[graph.length];
        int dis[]=new int[graph.length];
        for(int i=0;i<dis.length;i++)
        {
            if(i!=src)
            dis[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<graph.length-1;i++)
        {
            for(int j =0;j<graph.length;j++)
            {
                for(int k=0;k<graph[j].size();k++)
                {
                    Edge e =graph[j].get(k);
                    if(dis[e.src]!=Integer.MAX_VALUE&& dis[e.src]+e.wht<dis[e.des])
                    {
                        dis[e.des]=dis[e.src]+e.wht;
                    }
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
