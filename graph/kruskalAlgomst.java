import java.util.*;
/**
 * kruskalAlgomst
 */
public class kruskalAlgomst {
    static class Edge implements Comparable<Edge>{
        int src;
        int des;
        int wht;
        public Edge(int s,int d ,int w)
        {
            this.src =s;
            this.des =d;
            this.wht = w;

        }
        @Override
        public int compareTo(Edge e2)
        {
            return this.wht - e2.wht;

        }
    }
    static void createGraph(ArrayList<Edge> edges)
    {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));

    }
    static int n =4;
    static int par[] =new int[n];
    static int rank[] = new int[n];
    public static void init ()
    {
        for(int i =0;i<n;i++)
        {
            par[i] = i;
             
        } 
    }

    static int find(int x){
        if(x==par[x])
        {
            return x;
        }
        return par[x] = find(par[x]);
    }

    static void union(int a ,int b)
    {
        int para=find(a);
        int parb =find(b);
        if(rank[para]==rank[parb])
        {
            par[para]=parb;
            parb++;

        }
        else if(rank[para]>rank[parb])
        {
            par[parb]=para;

        }
        else
        {
            par[para]=parb;

        }
    }
    public static void  kruskal(ArrayList<Edge> edges ,int V)
    {
        init();
        Collections.sort(edges);
        int mstCost=0;
        int count =0;
        for(int i=0;count<V-1;i++)
        {
            Edge e = edges.get(i);

            int para= find(e.des);
            int parb =find(e.src);
            if(para!=parb)
            {
            union(para, parb);
            mstCost+=e.wht;
            count++;}



        }
        System.out.println(mstCost);
        }
    public static void main(String[] args) {
        int V= 4;
        ArrayList<Edge> ar = new ArrayList<>();
        createGraph(ar);
        kruskal(ar,V);
    }
}