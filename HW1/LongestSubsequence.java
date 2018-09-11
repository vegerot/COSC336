package longest;
import java.util.*;

/*
 * Written by: Max Coplan, Zachary Kafka, Andrew Willinham, Sage Isaac
 * COSC 336-002
 * Zimand
 * Due 9/11/2018
 * This class calculates the longest increasing subsequence of a set of numbers
 *
 *
 *This code finds the longest subsequence by searching through the code,
 *skipping any number with a smaller number directly after it if both could be added to the list.
 *This is because if any larger number or a smaller number can be put on the list
 *the smaller of the two will always allow an equal or higher potential of 
 *numbers to be added to the list folowing it. Then repeat the process.
 *
 *
 
 
Please copy and paste the following Tests to test the program's functionality
(copy the examples in quotation marks)
   Test 1
   8 in List
   "10 9 2 5 3 7 101 18 STOP"
   Length of longest increasing subsequence is: 4
   Longest Subsequence is: 2 3 7 18 
 
   Test 2
   50 in list
   "186  359  274  927  890  520  571  310  916  798  732  23  
   196  579  426 188  524  991  91  150  117  565  993  615  
   48  811  594  303  191  505  724  818  536  416  179  485   
   334   74  998  100  197  768  421  114  739  636  356  908   
   477  656 STOP"
   Length of longest increasing subsequence is: 10
   Longest Subsequence is: 186 274 310 426 524 565 594 724 739 908 
  
   Test 3
   50 in list
   "318   536   390   598   602   408   254   868   379   565
   206   619   936   195   123   314   729   608   148   540
   256   768   404   190   559   1000   482   141   26  230
   550   881   759   122   878  350  756  82  562  897  508
   853  317   380   807   23   506   98   757   247 STOP"
   Length of longest increasing subsequence is: 9
   Longest Subsequence is: 123 148 256 404 482 550 759 878 897 
  
 */

public class LongestSubsequence
{

	//====================================
	// Auto run main method
	//====================================
	public static void main(String[] args)
	{
		
		System.out.println("Longest Subsequence\n====================\n");
		ArrayList<Integer> originalList = new ArrayList<Integer>();
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter list of numbers(enter string to stop): ");
		//user may enter input in terminal either as shell arguments (e.g. java LongestSubsequence 1 9 6 2 10) or enter during program evaluation
		if (args.length != 0)
			for (int i = 0; i < args.length; i++)
				originalList.add(Integer.parseInt(args[i]));
                //while loop allows user to enter elements seperated by a space until a string is entered (e.g. 1 9 6 2 10 STOP)
		else while(input.hasNextInt())
			originalList.add(input.nextInt());
		
		input.close();
		System.out.println("Original list: ");
		print(originalList);
		
		//user entered elements are sent to 'LongestIncreasingSubsequence' function
		int[] result = longestIncreasingSubsequence(originalList);      
		
		System.out.println("\nLength of longest increasing subsequence is: " + result.length);
		System.out.print("\nLongest Subsequence is: "); 
		print(result);
	}
	
	//====================================
	// Displays Array
	//====================================
	public static void print(int[] nums)
	{
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");            
		System.out.println();
	}
	
	//====================================
	// Displays ArrayList
	//====================================
	public static void print(ArrayList<Integer> nums)
	{
		for (int i = 0; i < nums.size(); i++)
			System.out.print(nums.get(i) + " ");            
		System.out.println();
	}

	//====================================
	// Runs the search for the longest increasing Subsequence
	//====================================
	public static int[] longestIncreasingSubsequence(ArrayList<Integer> original)
	{ 
		int element = 0;
		int length = original.size(); 
		ArrayList<Integer> workingPointers = new ArrayList<Integer>(Collections.nCopies(length + 1, 0));
		ArrayList<Integer> resultPointers = new ArrayList<Integer>(Collections.nCopies(length + 1, 0));
		
		for (int i = 0; i < length; i++)
		{
			int j = 0;
			//search for elements
			for (int k = element/*k is starting at 0*/; k >= 1; k--)
			{
				if (original.get(workingPointers.get(k)) < original.get(i))
				{
					j = k;
					break;
				}
			}

			resultPointers.set(i,workingPointers.get(j));
			if (j == element || original.get(i) < original.get(workingPointers.get(j + 1)))
			{
				workingPointers.set(j + 1, i);
				//====================================
				//math function used to assign elements
				//====================================
				element = Math.max(element,j + 1);
			}
		}
		//====================================
		// backtracking process
		//====================================
		int[] result = new int[element];
		int k = workingPointers.get(element);
		for (int i = element - 1; i >= 0; i--)
		{
			result[i] = original.get(k);
			k = resultPointers.get(k);
		}
		return result;            
	}
}
