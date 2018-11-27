package program_assignment_1;
/*
    NOTE:
    *** This program does NOT find the fastest path to the exit.
    The program prints the first path to the exit, or the closest path to the exit
    that the path finding algorithm finds.  ***
*/
//  Import util and io package for user input, file reading, and exceptions
import java.util.*;
import java.io.*;
public class Program_Assignment_1 {
    
    public static void main(String[] args){
        //  Method to get the dimensions of the maze and check if they are valid
        int dim[] = getDimensions();
        if(dim[0] == 0 || dim[1] == 0)
        {
            System.out.println("Invalid Dimensions.");
            return;
        }
        //  Set dimensions of array to variables
        int mazeLength = dim[0], mazeHeight = dim[1];
        //  2D array to hold the maze
        char[][] maze = new char[mazeHeight][mazeLength];
        //  Method to store the maze in the array
        storeMaze(maze, mazeHeight);
        
        System.out.println("Maze: exit = E");
        //  Method to print the maze
        printMaze(maze, mazeLength, mazeHeight);
        
        //  Set up Scanner to read user input
        Scanner keyboard = new Scanner(System.in);
        //  x,y to get start co-ordinates for maze traversal
        int x = -1, y = -1;
        
        System.out.println();
        //  Get user input
        System.out.println("Enter starting co-ordinates:");
        //  Make sure the input co-ordinates don't land on a 1
        boolean exit = false;
        while(!exit)
        {
            int[] coords = getCoords(keyboard, mazeLength, mazeHeight);
            x = coords[0];
            y = coords[1];
            //  Checks if co-ordinates are on a 1 (ASCII code 49)
            if(maze[x][y] == 49)
            {
                System.out.println("Cannot start maze here, try different co-ordinates.");
            }
            else
                exit = true;
            //  If co-ordinates entered are at the exit, don't continue the program
            if(x == 0 && y == 0)
            {
                System.out.println("You started at the exit! You are free!");
                return;
            }
        }
        //  Create a Path to find the path to the exit, if found, the method prints "I am free!", if not found, prints "Help, I am trapped!"
        Path mazePath = new Path(new PathNode(maze, x, y), maze);
        System.out.println();
        mazePath.findPath(mazePath.getStart());
        //  Set the path generated from findPath to a single linked list in Solution object, creates path for both cases (path found/not found) 
        Solution mazeSolution = new Solution(new SolutionNode(mazePath.getStart().getX(), mazePath.getStart().getY()));
        buildSolution(mazePath, mazeSolution);
        //  Print out the path, exit the program
        System.out.println("Path:");
        mazeSolution.printSteps();
        
    }
    //  Method to get the coordinates of the start point
    public static int[] getCoords(Scanner s, int xbound, int ybound)
    {
        //  Have a boolean variable to check if the loops should repeat if user inputs incorrectly
        boolean exit = false;
        //  Set co-ordinates to base case values
        int x = -1, y = -1;
        while(!exit)
        {
            System.out.println("Enter x start value:");
            x = s.nextInt();
            //  Make sure the input is in bounds
            if(x < 0 || x > xbound - 1)
                System.out.println("Enter a valid x value.");
            else
                exit = true;
        }
        //  Reset to get y value
        exit = false;
        while(!exit)
        {
            System.out.println("Enter y start value:");
            y = s.nextInt();
            if(y < 0 || y > ybound - 1)
                System.out.println("Enter a valid y value.");
            else
                exit = true;
        }
        //  Return co-ordinates as an array of 2 integers
        int[] coords = {x,y};
        return coords;
    }
    //  Method to get the dimensions of the maze from the input file
    public static int[] getDimensions()
    {
        //  Base return array
        int[] dim = {0,0};
        //  Put the file.txt in a scanner if it exists
        Scanner readFile = null;
        try{
            File maze = new File("maze.txt");
            readFile = new Scanner(maze);
        }catch(FileNotFoundException e)
        {
            System.out.println("maze.txt does not exist.");
            return dim;
        }
        //  Base case for variables that will be stored in the array
        int mazeLength = 0, mazeHeight = 0;
        //  Make sure the file actually has a maze in it, update dimensions with info from file
        try{
            String mazeL1 = readFile.nextLine();
            mazeLength = mazeL1.length();
            mazeHeight = 1;
            while(readFile.hasNextLine())
            {
                readFile.nextLine();
                mazeHeight++;
            }
        }catch(NoSuchElementException e)
        {
            System.out.println("File is empty.");
            return dim;
        }
        //  Update array and return
        dim[0] = mazeLength;
        dim[1] = mazeHeight;
        return dim;
    }
    //  Method to store the maze into a passed array
    public static void storeMaze(char[][] mazeArray, int ybound)
    {
        //  Reset scanner to start of maze.txt
        Scanner readFile = null;
        try{
            File maze = new File("maze.txt");
            readFile = new Scanner(maze);
        }catch(FileNotFoundException e)
        {
            System.out.println("maze.txt does not exist.");
            return;
        }
        int i = 0;
        //  Set each character of the file to an element of the array
        while(readFile.hasNextLine() && i < ybound)
        {
            String current = readFile.nextLine();
            for(int j = 0; j < current.length(); j++)
            {
                mazeArray[i][j] = current.charAt(j);
            }
            i++;
        }
    }
    //  Method to print the maze to the user
    public static void printMaze(char[][] maze, int xbound, int ybound)
    {
        //  Print a row of labels for each of the collumns
        System.out.print("\t");
        for(int i = 0; i < xbound; i++)
        {
            if(i < 10)
                System.out.print(i + "  ");
            else
                System.out.print(i + " ");
        }
        System.out.println("\n");
        //  Print numbered rows countaining the contents of the maze
        for(int i = 0; i < ybound; i++)
        {
            System.out.print(i + "\t");
            for(int j = 0; j < xbound; j++)
            {
                System.out.print(maze[i][j] + "  ");
            }
            System.out.println();
        }
    }
    //  Method to transfer the path from Path p to Solution s
    public static void buildSolution(Path p, Solution s)
    {
        PathNode temp = p.getStart();
        while(temp != null)
        {
            s.append(new SolutionNode(temp.getX(), temp.getY()));
            temp = temp.getNext();
        }
    }
}
