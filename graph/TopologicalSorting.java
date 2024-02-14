import java.util.*;


public class TopologicalSorting {
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
    public static void detectCycleUtil(ArrayList<Edge>[] graph,int curr,boolean[] vis, Stack<Integer> stack)
    {
        vis[curr]= true;
        
        for(int i = 0;i<graph[curr].size();i++)
        {
            int desti = graph[curr].get(i).des;

            if(!vis[desti])
            {
                
                detectCycleUtil(graph, desti, vis, stack);
            }
           
        }
        stack.push(curr);
        
    }
    public static void detectCycle(ArrayList<Edge>[] graph)
    {
        boolean vis[] = new  boolean[graph.length];
        Stack<Integer> stack= new  Stack<>();
        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i])
            {
                detectCycleUtil(graph,i,vis,stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop()+" ");
        }
    }
    public static void main(String args[]) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        //vertex 0
        graph[2].add(new Edge(2, 3, 5));

        // vertex 1
        graph[3].add(new Edge(3, 1, 1));
       

        // vertex 2
        
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

       
    
       

        //vertex 3\
        graph[5].add(new Edge(5, 0, 1));

        graph[5].add(new Edge(5,2 ,2 ));
        detectCycle(graph);
    }
}
