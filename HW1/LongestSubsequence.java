import java.util.*;
public class LongestSubsequence {
  
  public static void main(String[] args) {   
    Scanner input = new Scanner(System.in);
    System.out.println("Longest Subsequence\n");
    System.out.println("Enter number of elements");
    int numEle = getInt(input);
    int[] list1 = new int[numEle + 1];
    System.out.println("\nEnter "+ numEle +" elements");
    int num = getInt(input);
    while (num != 999) {
      for (int i = 1; i <= numEle; i++){
        list1[i] = num;
        num = getInt(input);
      }
    }
    LongestSubsequence obj = new LongestSubsequence();
    int[] result = obj.lis(list1);      
    //printing values
    System.out.println("\nLength of increasing subsequence is:"+result.length);
    System.out.print("\nLongest Subsequence is: "); 
    for (int i = 0; i < result.length; i++)
      System.out.print(result[i] +" ");            
    System.out.println();
  }
  
  //Methods
  public static int getInt(Scanner scan) {
    int number = 0;
    boolean done = false;
    while (!done) {
      try {
        number = scan.nextInt();
        if (number < 0 ) {
          System.out.println("Number has to be 0 or greater. Try again: ");
        }
        else {
          done = true;
        }
      }
      catch (InputMismatchException e) {
        System.out.println("Not an integer. Try again.");
        scan.nextLine();
      }
    }
    return number;
  }
  
  public static int[] lis(int[] array1){       
    int number = array1.length;
    int[] array2 = new int[number];
    int[] array3 = new int[number];
    int ele = 0;
    for (int i = 1; i < number; i++) {
      int j = 0;
      //search for elements
      for (int k = ele ; k >= 1; k--){
        if (array1[array2[k]] < array1[i]){
          j = k;
          break;
        }
      }           
      array3[i] = array2[j];
      if (j == ele || array1[i] < array1[array2[j + 1]])
      {
        array2[j + 1] = i;
        //math funtion used to assign elements
        ele = Math.max(ele,j + 1);
      }
    }
    //backtracking process
    int[] result = new int[ele];
    int k = array2[ele];
    for (int i = ele - 1; i >= 0; i--)
    {
      result[i] = array1[k];
      k = array3[k];
    }
    return result;            
  }
}
/*
 Test 1
 8 in List
 10 9 2 5 3 7 101 18 999
 
 Test 2
 50 in list
 186  359  274  927  890  520  571  310  916  798  732  23  
 196  579  426 188  524  991  91  150  117  565  993  615  
 48  811  594  303  191  505  724  818  536  416  179  485   
 334   74  998  100  197  768  421  114  739  636  356  908   
 477  656 999
 
 Test 3
 50 in list
 318   536   390   598   602   408   254   868   379   565
 206   619   936   195   123   314   729   608   148   540
 256   768   404   190   559   1000   482   141   26  230
 550   881   759   122   878  350  756  82  562  897  508
 853  317   380   807   23   506   98   757   247 999
 */