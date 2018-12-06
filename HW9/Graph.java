// A Java program for Bellman-Ford's single source shortest path 
// algorithm. 
import java.util.*; 
import java.lang.*; 
import java.io.*; 

// A class to represent a connected, directed and weighted graph 
class Graph 
{
   static final int f=999; 
	// A class to represent a weighted edge in graph 
	class Edge { 
		int src, dest, weight; 
		Edge() { 
			src = dest = weight = 0; 
		} 
	}; 

	int V, E; 
	Edge edge[];
    //int prev[]; 

	// Creates a graph with V vertices and E edges 
	Graph(int v, int e) 
	{ 
		V = v; 
		E = e; 
		edge = new Edge[e]; 
		for (int i=0; i<e; i++) 
			edge[i] = new Edge();
       //prev=new int[v]; 
	} 

	// The main function that finds shortest distances from src 
	// to all other vertices using Bellman-Ford algorithm. The 
	// function also detects negative weight cycle 
	void modifiedBellmanFord(Graph graph,int src,int k) 
	{ 
		int V = graph.V, E = graph.E; 
		int previousDist[] = new int[V];
        int newDist[] = new int[V];
        //if (k>V) //would k>V or k>E ????
           // k=V;
        System.out.println("k= "+k);

		// Step 1: Initialize distances from src to all other 
		// vertices as INFINITE 
		for (int i=0; i<V; i++) 
        {
            previousDist[i]=999;
			newDist[i] = 999; 
            //prev[i]=999;
        }
		previousDist[src] = 0; 
        newDist[src]=0;

		// Step 2: Relax all edges |V| - 1 times. A simple 
		// shortest path from src to any other vertex can 
		// have at-most |V| - 1 edges 
		for (int i=1; i<k+1; i++) 
		{ 
            for (int j=0; j<V; j++)
            {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                previousDist[u]=newDist[v];
            }
			for (int j=0; j<E; j++) 
			{ 
				int u = graph.edge[j].src; 
				int v = graph.edge[j].dest; 
				int weight = graph.edge[j].weight; 
				if (previousDist[u]!=999&&newDist[v]>previousDist[u]+weight)
                { 
					newDist[v]=previousDist[u]+weight; 
              //      prev[v]=u;
                }
                printArr(newDist,V);
			}
        //   printArr(dist,V); 
		} 

		
       System.out.println("FINAL"); 
		printArr(newDist, V); 
	} 

	// A utility function used to print the solution 
	void printArr(int dist[], int V) 
	{ 
		System.out.println("\nVertex  Distance from Source  Previous"); 
		for (int i=0; i<V; i++) 
			System.out.println(i+"\t\t"+dist[i]+"\t\t"); 
	}

    public static void shortestPath(int graph[][], int src, int dest, int k, int V, int E)
    {
        int previousDist[] = new int[V];
        int newDist[] = new int[V];
        int prev[] = new int[V];
        if (k>V) 
           k=V;
        System.out.println("\nk= "+k);

        // Step 1: Initialize distances from src to all other
        // vertices as INFINITE
        for (int i=0; i<V; i++)
        {
            previousDist[i]=f;
            newDist[i] = f;
            prev[i]=f;
        }
        previousDist[src] = 0;
        newDist[src]=0;

        // Step 2: Relax all edges at most k times. A simple
        // shortest path from src to any other vertex can
        // have at-most |V| - 1 edges so set k to v when k was greater than V
        for (int i=1; i<k+1; i++)
        {
            for (int v=0; v<V; v++)
            {
                previousDist[v]=newDist[v];
            }
            for (int u=0; u<V; u++){

                for (int v=0; v<V; v++)
                {
                    if (graph[u][v]!=f&&previousDist[u]!=f)
                    {
                        if (newDist[v]>previousDist[u]+graph[u][v])
                        {
                            prev[v]=u;
                        }
                        
                            newDist[v]=Math.min(newDist[v], previousDist[u]+graph[u][v]); 
                    }
                }}
           //printArr(newDist,V);
        

 
        }
        
            System.out.println("Start\t\tend\t\tlength");
        if (newDist[dest]!=f)
            System.out.println((src+1)+"\t\t"+(dest+1)+"\t\t"+newDist[dest]);
        else
            System.out.println((src+1)+"\t\t"+(dest+1)+"\t\t"+"NOT FOUND");

    } 

} 
// Inspired by Aakash Hasija code on Geeks For Geeks


