import java.util.*;

class ConnectedComponent {
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

    public static void dfsUtil(int curr, ArrayList<Edge>[] graph,boolean[] vis )
    {
        System.out.println(curr+ " ");
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++)
        {
           
            int desti =graph[curr].get(i).des;
            if(!vis[desti]){
                
                dfsUtil(desti, graph, vis);
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge>[] graph,int curr,boolean[] vis)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        while(!q.isEmpty())
        {
            int curr1 = q.poll();
            if(!vis[curr1])
            {
                System.out.println(curr1+" ");
                vis[curr1]=true;
            
            
            for(int i=0;i<graph[curr].size();i++)
            {
                q.add(graph[curr].get(i).des);
            }
        }
        }    
    }
    public static void bfs(ArrayList<Edge>[] graph)
    {
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i])
            {
                bfsUtil(graph, i, vis);
            }
        }
    }
    public static void dfs(ArrayList<Edge>[] graph)
    {
        boolean vis[]=new boolean[graph.length];
        for(int i =0;i<graph.length;i++)
        {
            
            if(!vis[i])
            {
                dfsUtil(i,graph,vis);
            }
        }
    }
    public static void main(String args[]) {
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

        bfs(graph);
    }
}