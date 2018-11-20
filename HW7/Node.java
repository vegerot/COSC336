// Java Program to demonstrate adjacency list  
// representation of graphs 
import java.util.LinkedList; 
import java.util.ArrayList;
  
public class Node
{ 
    // A user define class to represent a graph. 
    // A graph is an array of adjacency lists. 
    // Size of array will be V (number of vertices  
    // in graph)

   private ArrayList<Node> children;
   private int value;
   public boolean visited;
	//public int pathLevel;

   LinkedList<Node> adjList=new LinkedList<>();
   int V;

   public Node(int v)
   {
	   this.value=v;
	   this.visited=false;
	   this.children=new ArrayList<Node>();
   }

   public int getValue()
   {
	   return this.value;
   }

   public ArrayList<Node> getChildren()
   {
	   return this.children;
   }
   public int addChild(Node n)
   {
		this.children.add(n);
		return n.value;
   }
   public int addChild(int n)
   {
		   this.children.add(new Node(n));
		   return n;
   }

   /*public boolean setVisited(boolean bool)
   {
	   this.visited=bool;
	   return bool
   }*/

      
    // Adds an edge to an undirected graph 
    public void addEdge(Node n1, Node n2) 
    {
		/*Node s=new Node(src);
        Node d=new Node(dest);*/
			
		n1.addChild(n2);
		n2.addChild(n1);
        // Add an edge from src to dest.  

         
        // Since graph is undirected, add an edge from dest 
        // to src also 
    } 
       
    // A utility function to print the adjacency list  
    // representation of graph 
    public void printGraph(Node[] graph) 
    {        
        for(int v = 0; v < graph.length; v++) 
        { 
            System.out.println("Adjacency list of vertex "+ v); 
            System.out.print("head"); 
            for(Node elem:graph[v].getChildren())
			{ 
                System.out.print(" -> "+elem.getValue()); 
            } 
            System.out.println("\n"); 
        } 
    } 

	public void print(Node[] graph)
	{
			for (int v=0; v<graph.length; v++)
			{
					for (Node elem:graph[v].getChildren())
					{
							if (!elem.visited)
							{
								System.out.print(elem.getValue()+" ");
								elem.visited=true;
							}
					}
					System.out.println();

			}
	}
       
    // Driver program to test above functions 
        // print the adjacency list representation of  
        // the above graph 
    //}
	public String toString()
	{
		return Integer.toString(this.value);
	}

	public boolean isNeighborOf(Node n2)
	{
		for (Node n: this.children)
			if (n.value==n2.value)
				return true;
		return false;
	}
} 
// This code is inspired by Sumit Ghosh. Completely written by Max Coplan, though
