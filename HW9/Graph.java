/*
 * This program finds the shortest wighted path within the restricted K number of edges used
 * This program finds this path by first looking at a every potential path from the current list of connections and updating the best path to each
 * After it has found the first path possible it spreads like a web, using a backup list to not move more than 1 space per iteration.
 * after K iterations it takes the most recent list and finds the target and determines what the best path value was and if none printing that it could not be reached
 * at the same time we have the best previous node for ease of error checking
 */
// A Java program for Bellman-Ford's single source shortest path 
// algorithm. 
import java.util.*; 
import java.lang.*; 
import java.io.*;

// A class to represent a connected, directed and weighted graph 
class Graph 
{
   static final int f=999; 
   int V, E; 

	// Creates a graph with V vertices and E edges 
	Graph(int v, int e) 
	{ 
		V = v; 
		E = e; 
	} 

	// The main function that finds shortest distances from src 
	// to all other vertices using a modified Bellman-Ford algorithm.  
    public static void shortestPath(int graph[][], int src, int dest, int k, int V, int E)
    {
        int previousDist[] = new int[V];
        int newDist[] = new int[V];
        int prev[] = new int[V];
        if (k>V) //shortest path can have at most |V|-1 edges
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
        for (int i=1; i<k+1; i++) //O(k)
        {
            for (int v=0; v<V; v++)
            {
                previousDist[v]=newDist[v];
            }
            for (int u=0; u<V; u++){

                for (int v=0; v<V; v++) //this is not O(V^2).  Because the next 'if' selects just the elements in the edges.  Therefore this loop is O(E)
                {
                    if (graph[u][v]!=f&&previousDist[u]!=f) //select just the edges
                    {
                        if (newDist[v]>previousDist[u]+graph[u][v])
                        {
                            prev[v]=u;
                        }
                        
                            newDist[v]=Math.min(newDist[v], previousDist[u]+graph[u][v]); 
                    }
                }}
            //Outer is O(k) and inner is O(E).  So total is O(k*E)
           //printArr(newDist,V);
        

 
        }
        



        System.out.println("Start\t\tend\t\tlength");
        if(newDist[dest]==f){
            System.out.println((src+1)+"\t\t"+(1+dest)+"\t\t"+"Cant be reached");
        }else{
            System.out.println((src+1)+"\t\t"+(1+dest)+"\t\t"+newDist[dest]);
        }
    } 

	// Driver method to test above function 
	public static void main(String[] args) 
	{ 
		int V = 6; // Number of vertices in graph 
		int E = 10; // Number of edges in graph 
        
        Graph g=new Graph(V,E);

        int graph[][] = new int[][]{ {0,f,f,f,-1,f},
                                     {1,0,f,2,f,f},
                                     {f,2,0,f,f,-8},
                                     {-4,f,f,0,3,f},
                                     {f,7,f,f,0,f},
                                     {f,5,10,f,f,0}
                                   };
    	g.shortestPath(graph, 5, 0, 3, V, E);
        g.shortestPath(graph, 2, 0, 2, V, E);
        g.shortestPath(graph, 2, 0, 3, V, E);

    } 
} 
// Inspired by Aakash Hasija code on Geeks For Geeks

