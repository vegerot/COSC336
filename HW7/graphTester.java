public class graphTester
{
		public static void main(String[] args)
		{
				// create the graph given in above figure 
        int V = 7; 
//      Graph graph=new Graph(V);
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        Node n7=new Node(7);
        

        Node[] graph=new Node[] {n1,n2,n3,n4,n5,n6,n7};

       n1.addEdge(n1,n2);
       n1.addEdge(n1,n3);
       n1.addEdge(n1,n4);
       n1.addEdge(n2,n5);
       n1.addEdge(n3,n5);
       n1.addEdge(n4,n6);
       n1.addEdge(n5,n7);
       n1.addEdge(n6,n7);


        System.out.println(n7.getValue());
        n1.printGraph(graph);



        // print the adjacency list representation of  
        // the above graph 

		}
}
