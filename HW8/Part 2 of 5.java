package program_assignment_1;

public class PathNode {
    private char value;
    private int x, y;
    private boolean visited;
    private PathNode north, east, south, west, last;
    private PathNode next;
    
    public PathNode(char[][] maze, int x, int y)
    {
        this.x = x;
        this.y = y;
        value = maze[x][y];
        visited = false;
        
        north = null;
        east = null;
        south = null;
        west = null;
        last = null;
        next = null;
    }
    
    //  Methods for setting and getting the co-ordinates
    public void setX(int x)
    {   this.x = x; }
    public void setY(int y)
    {   this.y = y; }
    public int getX()
    {   return x;   }
    public int getY()
    {   return y;   }
    //  Method to get the stored value of the node, this will be a 1(ASCII 49), a 0(ASCII 48), or an E(ASCII 69)
    public int getVal()
    {   return value;   }
    
    //  Methods to change and check visited status
    public void visit()
    {   visited = true; }
    public boolean visitCheck()
    {   return visited; }
    
    //  Methods for setting the nodes in the cardinal directions
    public void setNorth(char[][] maze)
    {
        try
        {
            north = new PathNode(maze, x-1, y);
        }catch(ArrayIndexOutOfBoundsException e)
        {
            north = null;
        }

    }
    public void setEast(char[][] maze)
    {
        try
        {
            east = new PathNode(maze, x, y+1);
        }catch(ArrayIndexOutOfBoundsException e)
        {
            east = null;
        }
    }
    public void setSouth(char[][] maze)
    {
        try
        {
            south = new PathNode(maze, x+1, y);
        }catch(ArrayIndexOutOfBoundsException e)
        {
            south = null;
        }
    }
    public void setWest(char[][] maze)
    {
        try
        {
            west = new PathNode(maze, x, y-1);
        }catch(ArrayIndexOutOfBoundsException e)
        {
            west = null;
        }
    }
    //  Methods to set and get last in the case that you have to go back through the maze
    public void setLast(PathNode last)
    {
        this.last = last;
    }
    public PathNode getLast()
    {   return last;    }
    
    //  Methods for getting the nodes in each cardinal direction
    public PathNode getNorth()
    {   return north;   }
    public PathNode getEast()
    {   return east;   }
    public PathNode getSouth()
    {   return south;   }
    public PathNode getWest()
    {   return west;   }
    
    //Method for setting the next object in the correct path
    public void setNext(PathNode next)
    {   this.next = next;   }
    public PathNode getNext()
    {   return next;    }
    
    //  Method for node comparison
    public boolean equals(PathNode n)
    {
        return x == n.getX() && y == n.getY();
    }
}
