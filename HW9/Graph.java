/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;
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
<<<<<<< HEAD
        
            System.out.println("Start\t\tend\t\tlength");
        if (newDist[dest]!=f)
            System.out.println((src+1)+"\t\t"+(dest+1)+"\t\t"+newDist[dest]);
        else
            System.out.println((src+1)+"\t\t"+(dest+1)+"\t\t"+"NOT FOUND");

=======

        System.out.println("Start\t\tend\t\tlength");
        if(newDist[dest]==f){
            System.out.println((src+1)+"\t\t"+(1+dest)+"\t\t"+"Cant be reached");
        }else{
            System.out.println((src+1)+"\t\t"+(1+dest)+"\t\t"+newDist[dest]);
        }
>>>>>>> 18b1c2780a8f2da12d44535627367a10094ca27a
    } 

<<<<<<< HEAD
	// Driver method to test above function 
	public static void main(String[] args) 
	{ 
		int V = 6; // Number of vertices in graph 
		int E = 10; // Number of edges in graph 

        int graph[][] = new int[][]{ {0,f,f,f,-1,f},
                                     {1,0,f,2,f,f},
                                     {0,2,0,f,f,-8},
                                     {-4,f,f,0,3,f},
                                     {f,7,f,f,0,f},
                                     {f,5,10,f,f,0}
                                   };
//        shortestPath(graph, 0,1,V,E);

		/*Graph graph = new Graph(V, E); 
		// add edge 0-1 (or A-B in above figure) 
		graph.edge[0].src = 0; 
		graph.edge[0].dest = 4; 
		graph.edge[0].weight = -1; 
		// add edge 0-2 (or A-C in above figure) 
		graph.edge[1].src = 1; 
		graph.edge[1].dest = 3; 
		graph.edge[1].weight = 2; 
		// add edge 1-2 (or B-C in above figure) 
		graph.edge[2].src = 1; 
		graph.edge[2].dest = 0; 
		graph.edge[2].weight = 1; 
		// add edge 1-3 (or B-D in above figure) 
		graph.edge[3].src = 2; 
		graph.edge[3].dest = 1; 
		graph.edge[3].weight = 2; 
		// add edge 1-4 (or A-E in above figure) 
		graph.edge[4].src = 2; 
		graph.edge[4].dest = 5; 
		graph.edge[4].weight = -8; 
		// add edge 3-2 (or D-C in above figure) 
		graph.edge[5].src = 3; 
		graph.edge[5].dest = 0; 
		graph.edge[5].weight = -4; 
		// add edge 3-1 (or D-B in above figure) 
		graph.edge[6].src = 3; 
		graph.edge[6].dest = 4; 
		graph.edge[6].weight = 3; 
		// add edge 4-3 (or E-D in above figure) 
		graph.edge[7].src = 4; 
		graph.edge[7].dest = 1; 
		graph.edge[7].weight = 7; 
		// add edge 4-3 (or E-D in above figure) 
		graph.edge[8].src = 5; 
		graph.edge[8].dest = 1; 
		graph.edge[8].weight = 5; 
		// add edge 4-3 (or E-D in above figure) 
		graph.edge[9].src = 5; 
		graph.edge[9].dest = 2; 
		graph.edge[9].weight = 10; */

//		graph.modifiedBellmanFord(graph, 0,3); 
	} 
=======
>>>>>>> 97d86f6d23c54254fcfe2dccd547a782688c729e
} 
// Inspired by Aakash Hasija code on Geeks For Geeks

