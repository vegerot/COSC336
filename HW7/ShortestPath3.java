/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortestpath;

import java.util.*;
public class shortestPath3
{
    public static ArrayList<Integer> shortestPath(Node[] graph, Node source, Node dest) 
{
        ArrayList<Integer> shortestPathList = new ArrayList<Integer>();
        boolean[] visited = new boolean[graph.length+2];

        Queue<Node> in = new LinkedList<Node>();
        

        in.add(source);
        visited[source.getValue()] = true;

        int levelCount=0;
        
        while (!in.isEmpty()) 
	{
            Node u = in.poll();
            u.pathLevel=levelCount;
            levelCount++;
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

        
        return findShortestPathList(dest, shortestPathList, source);
}
    public static ArrayList<Integer> findShortestPathList(Node dest, ArrayList<Integer> shortestPathList, Node source){
    
        // To find the path
        Node node=dest;
        shortestPathList.add(source.getValue());
        Stack<Node> reversePath = new Stack<Node>();
        
        for(Node currentSrc: dest.getChildren()){
            if (currentSrc.isNeighborOf(node)) 
	    {
                shortestPathList.add(node.getValue());
                currentSrc = node;
                if (node == source)
                    break;
            }
            
        }// needs work
        /*while (!reversePath.isEmpty()) 
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
*/
        return shortestPathList;
}
}
