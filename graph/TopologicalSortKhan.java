import java.util.*;


public class TopologicalSortKhan {
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
    public static void calcIndeg(ArrayList<Edge> graph[],int indeg[])
    {
        for(int i=0;i<graph.length;i++)
        {
            int v =i;
            for(int j=0;j<graph[v].size();j++)
            {
                Edge e =graph[v].get(j);
                indeg[e.des]++;
            }
        }
    }    
    public static void topSort(ArrayList<Edge> graph[])
    {
        int indeg[] =new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q =new LinkedList<>();

        for(int i=0;i<indeg.length;i++)
        {
            if(indeg[i]==0)
            {
                q.add(i);

            }
        }

        while(!q.isEmpty())
        {
            int curr =q.remove();
            System.out.println(curr+" ");
            for(int i=0;i<graph[curr].size();i++)
            {
                Edge e = graph[curr].get(i);
                indeg[e.des]--;
                if(indeg[e.des]==0)
                {
                    q.add(e.des);
                }
            }
        }
        System.out.println();
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
        topSort(graph);
    }
}
