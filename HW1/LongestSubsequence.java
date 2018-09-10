import java.util.*;
public class LongestSubsequence {
  
  public static void main(String[] args) {   
    Scanner input = new Scanner(System.in);
    System.out.println("Longest Subsequence\n");
    ArrayList<Integer> originalList=new ArrayList<Integer>();
    System.out.print("Enter list of numbers(enter string to stop): ");
    //while loop allows user to enter elements seperated by a space until a string is entered
    while(input.hasNextInt()){
	    originalList.add(input.nextInt());
      
    }
    System.out.println("Original list: ");
    for (int z = 0; z < originalList.size();z++)
	    System.out.print(originalList.get(z) + " "); 
    System.out.println();
    //user entered elements are sent to 'LongestIncreasingSubsequence' function
    int[] result = LongestIncreasingSubsequence(originalList);      
    //printing values
    System.out.println("\nLength of longest increasing subsequence is: "+result.length);
    System.out.print("\nLongest Subsequence is: "); 
    for (int i = 0; i < result.length; i++)
      System.out.print(result[i] +" ");            
    System.out.println();
  }
  
  public static int[] LongestIncreasingSubsequence(ArrayList<Integer> original){ 
    int length = original.size(); 
    int[] workingPointers = new int[length];
    int[] resultPointers = new int[length];
    int ele = 0;
    for (int i = 0; i < length; i++) {
      int j = 0;
      //search for elements
      for (int k = ele/*k is starting at 0*/ ; k >= 1; k--){
        if (original.get(workingPointers[k]) < original.get(i)){
          j = k;
          break;
        }
      }
      
      resultPointers[i] = workingPointers[j];
      if (j == ele || original.get(i) < original.get(workingPointers[j + 1])){
        workingPointers[j + 1] = i;
        //math funtion used to assign elements
        ele = Math.max(ele,j + 1);
      }
    }
    
    //backtracking process
    int[] result = new int[ele];
    int k = workingPointers[ele];
    for (int i = ele - 1; i >= 0; i--){
      result[i] = original.get(k);
      k = resultPointers[k];
    }
    return result;            
  }
}
/*
 Test 1
 8 in List
 10 9 2 5 3 7 101 18 STOP
 Length of longest increasing subsequence is: 4
 Longest Subsequence is: 2 3 7 18 

 Test 2
 50 in list
 186  359  274  927  890  520  571  310  916  798  732  23  
 196  579  426 188  524  991  91  150  117  565  993  615  
 48  811  594  303  191  505  724  818  536  416  179  485   
 334   74  998  100  197  768  421  114  739  636  356  908   
 477  656 STOP
 Length of longest increasing subsequence is: 10
 Longest Subsequence is: 186 274 310 426 524 565 594 724 739 908 

 Test 3
 50 in list
 318   536   390   598   602   408   254   868   379   565
 206   619   936   195   123   314   729   608   148   540
 256   768   404   190   559   1000   482   141   26  230
 550   881   759   122   878  350  756  82  562  897  508
 853  317   380   807   23   506   98   757   247 STOP
 Length of longest increasing subsequence is: 9
 Longest Subsequence is: 123 148 256 404 482 550 759 878 897 
  */
