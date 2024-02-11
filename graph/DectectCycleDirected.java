import java.util.*;


public class DectectCycleDirected {
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
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph,int curr,boolean[] vis, boolean[] stack)
    {
        vis[curr]= true;
        stack[curr]= true;
        for(int i = 0;i<graph[curr].size();i++)
        {
            int desti = graph[curr].get(i).des;

            if(stack[desti])
            {
                return true;

            }
            else if(!vis[desti]&&detectCycleUtil(graph, desti, vis, stack))
            {
                return true;
            }
        }
        return false;
    }
    public static boolean detectCycle(ArrayList<Edge>[] graph)
    {
        boolean vis[] = new  boolean[graph.length];
        boolean stack[] = new  boolean[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i])
            {
                if(detectCycleUtil(graph,i,vis,stack)){
                    return true;
                }
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
        //vertex 0
        graph[0].add(new Edge(0, 2, 5));

        // vertex 1
        graph[1].add(new Edge(1, 0, 1));
       

        // vertex 2
        
        graph[2].add(new Edge(2, 3, 1));
       
    
       

        //vertex 3
        graph[3].add(new Edge(3,0 ,2 ));
        System.out.println(detectCycle(graph));
    }
}
