import java.util.*;
public class shortestPath2
{
public static ArrayList<Integer> shortestPath(Node[] graph, Node source, Node dest) 
{
        ArrayList<Integer> shortestPathList = new ArrayList<Integer>();
        boolean[] visited = new boolean[graph.length+2];

        Queue<Node> in = new LinkedList<Node>();
        Stack<Node> reversePath = new Stack<Node>();

        in.add(source);
        reversePath.add(source);
        visited[source.getValue()] = true;

        while (!in.isEmpty()) 
	{
            Node u = in.poll();
            for (Node v : u.getChildren()) 
	    {
                if (!visited[v.getValue()]) 
		{
                    in.add(v);
                    visited[v.getValue()] = true;
                    reversePath.add(v);
                    if (u.getValue() == dest.getValue())
                        break;
                }
            }
        }

        // To find the path
        Node node, currentSrc = dest;
        shortestPathList.add(dest.getValue());
        while (!reversePath.isEmpty()) 
	{
            node = reversePath.pop();
            if (currentSrc.isNeighborOf(node)) 
	    {
                shortestPathList.add(node.getValue());
                currentSrc = node;
                if (node == source)
                    break;
            }
        }

        return shortestPathList;
}
}
