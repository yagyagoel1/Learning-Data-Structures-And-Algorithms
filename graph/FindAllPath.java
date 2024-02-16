import java.util.*;


public class FindAllPath {
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
    public static void pathFinder(ArrayList<Edge>[] graph,int src,int dest,String path)
    {
        if(src==dest)
        {
            System.out.println(path+src);
            return ;

        }
        for(int i=0;i<graph[src].size();i++)
        {
            Edge e = graph[src].get(i);
            pathFinder(graph, e.des, dest, path+src);
        }
    }

    public static void main(String args[]) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,3,4));
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
        pathFinder(graph,5 , 1, "");
    }
}
