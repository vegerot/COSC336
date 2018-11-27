package program_assignment_1;

public class Path {
    private PathNode start;
    private PathNode current;
    private char[][] maze;
    
    public Path(PathNode start, char[][] maze)
    {
        this.start = start;
        this.current = start;
        this.maze = maze;
    }
    //  Method to return start of the path
    public PathNode getStart()
    {
        return start;
    }
    //  Method to return the current location of the path being taken
    public PathNode getCurrent()
    {
        return current;
    }
    //  Algorithm to formulate a path to the exit if one exists
    public void findPath(PathNode current)
    {
        //  Set current of the Path object to the passed PathNode
        this.current = current;
        //  If current location is the start of the path, set its last location to itself for condition checking
        if(current.getLast() == null)
            current.setLast(current);
        //  Set the current node's visited status to true
        current.visit();
        //  Check if the node to the north of the current node exists
        if(current.getNorth() == null)
        {
            current.setNorth(maze);
        }
        //  Make sure the current node isnt the exit
        if(current.getNorth() != null && current.getVal() != 69)
        {
            //  Check if the current node has not been visited, if it is not the previous node, and if it does not exist somewhere in the path taken already
            if(!current.getNorth().visitCheck() && !(current.getNorth().equals(current.getLast())) && !nodeExists(current))
            {
                //  Check if the current node is the exit
                if(current.getNorth().getVal() == 69)
                {
                    current.setNext(current.getNorth());
                    return;
                }
                //  Check if the north of the current node is not a wall, if so, move there and recursive call the function with that location
                else if(current.getNorth().getVal() != 49)
                {
                    current.getNorth().setLast(current);
                    current.setNext(current.getNorth());
                    findPath(current.getNorth());
                    return;
                }
            }
        }
        //  Process repeats for east, south, and west in that order
        if(current.getEast() == null)
        {
            current.setEast(maze);
        }
        if(current.getEast() != null && current.getVal() != 69)
        {
            if(!current.getEast().visitCheck() && !current.getEast().equals(current.getLast()) && !nodeExists(current))
            {
                if(current.getEast().getVal() == 69)
                {
                    current.setNext(current.getEast());
                    return;
                }
                else if(current.getEast().getVal() != 49)
                {
                   current.getEast().setLast(current);
                   current.setNext(current.getEast());
                   findPath(current.getEast());
                   return;
                }
            }
        }
        if(current.getSouth() == null)
        {
            current.setSouth(maze);
        }
        if(current.getSouth() != null && current.getVal() != 69)
        {
            if(!current.getSouth().visitCheck() && !current.getSouth().equals(current.getLast()) && !nodeExists(current))
            {
                if(current.getSouth().getVal() == 69)
                {
                    current.setNext(current.getSouth());
                    return;
                }
                else if(current.getSouth().getVal() != 49)
                {
                    current.getSouth().setLast(current);
                    current.setNext(current.getSouth());
                    findPath(current.getSouth());
                    return;
                }
            }
        }
        if(current.getWest() == null)
        {
            current.setWest(maze);
        }
        if(current.getWest() != null && current.getVal() != 69)
        {
            if(!current.getWest().visitCheck() && !current.getWest().equals(current.getLast()) && !nodeExists(current))
            {
                if(current.getWest().getVal() == 69)
                {
                    current.setNext(current.getWest());
                    findPath(current.getWest());
                    return;
                }
                else if(current.getWest().getVal() != 49)
                {
                    current.getWest().setLast(current);
                    current.setNext(current.getWest());
                    findPath(current.getWest());
                    return;
                }
            }
        }
        //  If the algorithm does not have any un-visited nodes to go to and:
            //  The current node is the exit, then print "I am free!" and exit algorithm
        if(current.getX() == 0 && current.getY() == 0)
        {
            System.out.println("I am free!");
        }
            //  The current node is the start node, print "Help, I am trapped!", no path to the exit has been found. Exit algorithm
        else if(current.equals(current.getLast()))
            System.out.println("Help, I am trapped!");
            //  The current node can go backwards, recursive call the function with the last node
        else
        {
            findPath(current.getLast());
            return;
        }
        
    }
    //  Method to see if a node exists. This is necessary to make sure that existing nodes are not recreated
    public boolean nodeExists(PathNode current)
    {
        PathNode temp = current;
        while(temp.getLast() != null){
            if(temp.getLast().equals(temp))
                return false;
            if(temp.getLast().equals(current))
                return true;
            temp = temp.getLast();
        }
        return false;
    }
    
}
