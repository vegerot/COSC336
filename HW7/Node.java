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
   boolean visited;

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
            for(Node elem:graph[v].getChildren()){ 
                System.out.print(" -> "+elem.getValue()); 
            } 
            System.out.println("\n"); 
        } 
    } 
       
    // Driver program to test above functions 
    /*public static void main(String args[]) 
    { 
        // create the graph given in above figure 
        int V = 7; 
//		Graph graph=new Graph(V);
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		Node n6=new Node(6);
		Node n7=new Node(7);
	 	
		Node[] graph=new Node[] {n1,n2,n3,n4,n5,n6,n7};
		
		addEdge(n1,n2);
		addEdge(n1,n3);
		addEdge(n1,n4);
		addEdge(n2,n5);
		addEdge(n3,n5);
		addEdge(n4,n6);
		addEdge(n5,n7);
		addEdge(n6,n7);


		System.out.println(n7.getValue());
		printGraph(graph);



        // print the adjacency list representation of  
        // the above graph 
    } */
} 
// This code is contributed by Sumit Ghosh.  Fixed and modified by Max Coplan
