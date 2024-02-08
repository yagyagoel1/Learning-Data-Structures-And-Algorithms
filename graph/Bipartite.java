import java.util.*;
public class Bipartite{
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
    public static boolean bipartiteUtil(ArrayList<Edge>[] graph ,int col[],int i)
    {  Queue<Integer> q =new LinkedList<>();

        q.add(i);
        while(!q.isEmpty())
        {
            int curr =q.remove();
            for(int j=0;j<graph[curr].size();j++)
            {
                int desti = graph[curr].get(j).des;
                if(col[desti]==-1)
                {
                    col[desti]= col[curr]==0?1:0;
                    q.add(desti);
                }
                else if(col[desti]==col[curr])
                {
                    return false;
                }

            }
        }
        return true;
    }
    public static boolean bipartite(ArrayList<Edge>[] graph)
    {
        int col[]= new int[graph.length];
        for(int i =0;i<graph.length;i++)
        {
            col[i]=-1;
        }
      
        for(int i =0;i<graph.length;i++)
        {
            if(col[i]==-1)
            {
                
                col[i]=0;
                if(!bipartiteUtil(graph, col, i))
                return false;

            }
           
        }
        return  true;
    }
    public static void main(String args[])
    {
        int v = 7;
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

        //vertex 5
        graph[5].add(new Edge(5,6,4));
        //vertex 6
        graph[6].add(new Edge(6,5,4));
        System.out.println(bipartite(graph));
    }
}