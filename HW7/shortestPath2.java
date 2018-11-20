import java.util.*;
public class shortestPath2
{
public static ArrayList<Integer> shortestPath(Node[] graph, Node source, Node dest) 
{
        ArrayList<Integer> shortestPathList = new ArrayList<Integer>();
        boolean[] visited = new boolean[100];

        Queue<Node> q = new LinkedList<Node>();
        Stack<Node> pathStack = new Stack<Node>();

        q.add(source);
        pathStack.add(source);
        visited[source.getValue()] = true;

        while (!q.isEmpty()) 
	{
            Node u = q.poll();
            for (Node v : u.getChildren()) 
	    {
                if (!visited[v.getValue()]) 
		{
                    q.add(v);
                    visited[v.getValue()] = true;
                    pathStack.add(v);
                    if (u.getValue() == dest.getValue())
                        break;
                }
            }
        }

        // To find the path
        Node node, currentSrc = dest;
        shortestPathList.add(dest.getValue());
        while (!pathStack.isEmpty()) 
	{
            node = pathStack.pop();
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
