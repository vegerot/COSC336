//Java program to find maximum rectangular area in linear time 
  
import java.util.Stack; 
import java.util.Scanner; 
public class PolygonRectangle 
{ 
    // The main function to find the maximum rectangular area under given 
    // histogram with n bars 
    static int getMaxArea(int hist[], int n)  
    { 
        // Create an empty stack. The stack holds indexes of hist[] array 
        // The bars stored in stack are always in increasing order of their 
        // heights. 
        Stack<Integer> s = new Stack<>(); 
          
        int max_area = 0; // Initialize max area 
        int tp;  // To store top of stack 
        int area_with_top; // To store area with top bar as the smallest bar 
       
        // Run through all bars of given histogram 
        int i = 0; 
        while (i < n) 
        { 
            // If this bar is higher than the bar on top stack, push it to stack 
            if (s.empty() || hist[s.peek()] <= hist[i]) 
                s.push(i++); 
       
            // If this bar is lower than top of stack, then calculate area of rectangle  
            // with stack top as the smallest (or minimum height) bar. 'i' is  
            // 'right index' for the top and element before top in stack is 'left index' 
            else
            { 
                tp = s.peek();  // store the top index 
                s.pop();  // pop the top 
       
                // Calculate the area with hist[tp] stack as smallest bar 
                area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1); 
       
                // update max area, if needed 
                if (max_area < area_with_top) 
                    max_area = area_with_top; 
            } 
        } 
       
        // Now pop the remaining bars from stack and calculate area with every 
        // popped bar as the smallest bar 
        while (s.empty() == false) 
        { 
            tp = s.peek(); 
            s.pop(); 
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1); 
       
            if (max_area < area_with_top) 
                max_area = area_with_top; 
        } 
       
        return max_area; 
  
    } 

    public static String getInput()
  {
    //=================================

    // Gets filename from user

    //=================================


    System.out.print("Input file here: ");
    Scanner cin=new Scanner(System.in);
    String file=cin.next();
    cin.close();
    return file;

  }

      
    // Driver program to test above function 
    public static void main(String[] args)  
    {
	String basename;
        if (args.length!=0)
	      basename=args[0];
    	else
              basename=getInput();


         String fn="../resources/"+basename;

	int[][] points=new fileParser(fn).getData();
	//int[][] points=new int[][]{{3, 0}, {3, 1}, {4, 1}, {4, 3}, {6, 3}, {6, 6},{10, 6}, {10,2}, {13, 2}, {13, 5}, {17, 5}, {17, 1}, {18, 1}, {18, 8}, {20,8}, {20, 0}}; 
        int hist[] = pointPadding.Padding(points); 
        System.out.println("Maximum area is " + getMaxArea(hist, hist.length)); 
    } 
} 
//This code is largely made by Sumit Ghosh.  Alterations to conform with COSC336 HW4 by Max Coplan, Sage Isaac, Zach, Andrew
