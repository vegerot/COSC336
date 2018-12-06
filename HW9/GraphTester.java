public class GraphTester
{
       static final int f=999;

    public static void main(String[] args)
    {
        int V = 6; // Number of vertices in graph
        int E = 10; // Number of edges in graph

        int graph[][] = new int[][]{ {0,f,f,f,-1,f},
                                     {1,0,f,2,f,f},
                                     {f,2,0,f,f,-8},
                                     {-4,f,f,0,3,f},
                                     {f,7,f,f,0,f},
                                     {f,5,10,f,f,0}
                                   };
        
        Graph g=new Graph(V,E);

        
        g.shortestPath(graph, 5,0,3,V,E);
        g.shortestPath(graph, 2,0,2,V,E);
        g.shortestPath(graph, 2,0,3,V,E);

    }
}
