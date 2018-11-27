package program_assignment_1;


public class Solution {
    private SolutionNode start;
    
    public Solution(SolutionNode start)
    {
        this.start = start;
    }
    //  Basic append method for a single linked list
    public void append(SolutionNode n)
    {
        SolutionNode temp = start;
        while(temp.getNext() != null)
            temp = temp.getNext();
        temp.setNext(n);
    }
    //  Method to print the co-ordinates of the steps taken on the final path
    public void printSteps()
    {
        SolutionNode temp = start;
        while(temp != null)
        {
            System.out.println(temp.getX() + "," + temp.getY());
            temp = temp.getNext();
        }
    }
}
