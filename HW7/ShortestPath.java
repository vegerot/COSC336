import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Stack;
public class ShortestPath
{
	public static ArrayList<LinkedList<Node>> Paths(Node[] graph, int start, int target)
	{
		/*int numNodesLeft= graph.getChildren().size();*/
		Stack<Node> s= new Stack<Node>();
		s.push(graph[start-1]);
		//numNodesLeft--;
		//
		ArrayList<LinkedList<Node>> paths=new ArrayList<>();
		int pathNumber=0;

		while(!s.empty() /*!v.visited && numNodesLeft>0*/)
		{
			paths.add(, new LinkedList<>());
			Node x=s.pop();
			if (!x.visited)
			{
				x.visited=true;
				paths.get(pathNumber).add(x);

			}
			if (x.getValue()==target)
				continue;

			/*count++;
			if(x==target)
			{
				return count;	
			}
			ArrayList<Node> children =v.getChildren()*/

			for(Node next: x.getChildren())
				if (!next.visited||next.getValue()==target)
					s.push(next);	
		}

		for (int i=0; i<paths.size(); i++)
			System.out.println(paths.get(i));
		return paths;

	}
}
