import java.util.*;
/**
 * shortestFlight
 */
public class shortestFlight {
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
    static class Info {
        int v;
        int cost;
        int stop;
        public Info(int v,int c,int s)
        {
            this.v=v;
            this.cost = c;
            this.stop =s;
        }
    }
    public static int cheapestFlight(int flights[][],int src,int k,int des)
    {
        ArrayList<Edge> graph[]=new ArrayList[flights.length];
        createGraph(flights, graph);
        int dis[] = new int[graph.length];

        for(int i=0;i<graph.length;i++)
        {
            if(src!=i)
            {
                dis[i]=Integer.MAX_VALUE;

            }
        }

        Queue<Info> q =new LinkedList<>(); 
        q.add(new Info(src, 0, 0));
        while(!q.isEmpty())
        {
            Info curr = q.remove();
          
            for(int i=0;i<graph[curr.v].size();i++)
            {
                Edge e = graph[curr.v].get(i);
                if(curr.cost+e.wht<dis[e.des]&&curr.stop<=k)
                {
                    dis[e.des] = curr.cost+e.wht;
                    q.add(new Info(e.des, dis[e.des], curr.stop+1));

                }
            }
        }

        return dis[des];

    }
    public static void createGraph(int flights[][],ArrayList<Edge> graph[])
    {
        for(int i=0;i<graph.length;i++)
        {
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<flights.length;i++)
        {
            int src = flights[i][0];
            int des = flights[i][1];
            int wht = flights[i][2];
            Edge e =new Edge(src, des, wht);
            graph[src].add(e);
        }
    }
public static void main(String[] args) {
    int n=4;
    int flights[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
    int src =0,dst=3,k=1;
    System.out.println(cheapestFlight(flights, src, k, dst));
    
}
    
}