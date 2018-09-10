//This version is with explainations. I would advise testing it with the smallest array first. THe arrays with 50 elements takes about 3 minutes to run fully.

import java.util.*;
public class LongestSubsequence {
  
  public static void main(String[] args) {   
    Scanner input = new Scanner(System.in);
    System.out.println("Longest Subsequence\n");
    //user enters number of elements (integers) for the array
    System.out.println("Enter number of elements to be placed in array:");
    int numEle = getInt(input);
    int[] list1 = new int[numEle + 1];
    System.out.println("\nEnter "+ numEle +" elements");
    int num = getInt(input);
    //while loop allows user to enter elements seperated by a space, 999 will signal to stop loop
    while (num != 999) {
      for (int i = 1; i <= numEle; i++){
        list1[i] = num;
        num = getInt(input);
      }
    }
    LongestSubsequence obj = new LongestSubsequence();
    //user entered elements are sent to 'lis' function
    int[] result = obj.lis(list1);      
    //printing values
    System.out.println("\nLength of increasing subsequence is:"+result.length);
    System.out.print("\nLongest Subsequence is: "); 
    for (int i = 0; i < result.length; i++)
      System.out.print(result[i] +" ");            
    System.out.println();
  }
  
  //Methods
  //getInt method validates that user is only entering integers
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
  /* 
   for (int z = 0; z < .length;z++)
   System.out.print( [z] + " ");
   System.out.println();
   */
  //System.out.println("I am printing ");//
  public static int[] lis(int[] array1){ 
    System.out.println("You have entered the main function! ");//
    int number = array1.length - 1;// minus 1 ??
    int[] array2 = new int[number];
    int[] array3 = new int[number];
    int ele = 0;
    System.out.print("I am printing array1:");//
    for (int z = 0; z < array1.length;z++)
      System.out.print( array1[z] + " ");
    System.out.println();
    System.out.print("I am printing array2: ");//
    for (int z = 0; z < array2.length;z++)
      System.out.print( array2[z] + " ");
    System.out.println();
    System.out.print("I am printing array3: ");//
    for (int z = 0; z < array3.length;z++)
      System.out.print( array3[z] + " ");
    System.out.println();
    for (int i = 1; i < number; i++) {
      System.out.println("I am printing from for loop #1 and the iteration is: " + i);//
      int j = 0;
      //search for elements
      for (int k = ele/*k is starting at 0*/ ; k >= 1; k--){
        System.out.println("I am printing from for loop #2 and the iteration is: " + k);//
        if (array1[array2[k]] < array1[i]){
          System.out.println("You have entered the if statement of for loop #2.");//
          System.out.print("I am printing array1[array2[k]] :" );//
          for (int z = 0; z < array1.length;z++)
            System.out.print( array1[z] + " ");
          System.out.println();
          System.out.print("I am printing array1[i] : ");//
          for (int z = 0; z < array1.length;z++)
            System.out.print( array1[z] + " ");
          System.out.println();
          System.out.println("I am printing j: " + j);
          j = k;
          System.out.println("I am printing k: " +k);//
          System.out.println("I am breaking from the if statement. ");//
          break;
        }
      }
      System.out.println("I am back in for loop #1! ");//
      
      System.out.print("I am printing array3[i] :" );//
      for (int z = 0; z < array3.length;z++)
        System.out.print( array3[z] + " ");
      System.out.println();
      System.out.print("I am printing array2[j] : " );//
      for (int z = 0; z < array2.length;z++)
        System.out.print( array2[z] + " ");
      System.out.println();
      array3[i] = array2[j];
      System.out.print("I am printing array3[i] : " );//
      for (int z = 0; z < array3.length;z++)
        System.out.print( array3[z] + " ");
      System.out.println();
      if (j == ele || array1[i] < array1[array2[j + 1]]){
        System.out.println("You have entered the if statement of for loop #1.");//
        System.out.println("I am printing j: " + j);//
        System.out.println("I am printing ele: " + ele);//
        System.out.print("I am printing array1[i] : ");//
        for (int z = 0; z < array1.length;z++)
          System.out.print( array1[z] + " ");
        System.out.println();
        System.out.print("I am printing array1[array2[j + 1]] : " );//
        for (int z = 0; z < array2.length;z++)
          System.out.print( array2[z] + " ");
        System.out.println();
        System.out.print("I am printing array2[j + 1] : ");//
        for (int z = 0; z < array2.length;z++)
          System.out.print( array2[z] + " ");
        System.out.println();
        System.out.println("I am printing i: " + i);//
        array2[j + 1] = i;
        System.out.print("I am printing array2[j + 1] = i : ");//
        for (int z = 0; z < array2.length;z++)
          System.out.print( array2[z] + " ");
        System.out.println();
        //math funtion used to assign elements
        System.out.println("You have the math function!");//
        System.out.println("I am printing ele: " + ele);//
        ele = Math.max(ele,j + 1);
        System.out.println("I am printing ele after the math funnction: " + ele);//
      }
      System.out.println("You have exited the if statement of for loop #1! ");//
    }
    
    //backtracking process
    System.out.println("You have exited for loop #1. ");//
    System.out.println("You have entered the back tracking process. ");//
    int[] result = new int[ele];
    System.out.print("I am printing result: ");//
    for (int z = 0; z < result.length;z++)
      System.out.print( result[z] + " ");
    System.out.println();
    int k = array2[ele];
    System.out.println("I am printing k after k = array2[ele] : " + k);//
    for (int i = ele - 1; i >= 0; i--){
      System.out.println("You have entered for loop #3! ");//
      System.out.println("I am printing result[i] : " + result[i]);//
      System.out.println("I am printing array1[k] : "+ array1[k]);//
      result[i] = array1[k];
      System.out.println("I am printing result[i] after result[i] = array1[k] : " + result[i]);//
      System.out.println("I am printing k: " + k);//
      k = array3[k];
      System.out.println("I am printing k after k = array3[k]: "+ k);//
    }
    System.out.println("You exited for loop #3! ");//
    System.out.println("The result will now be returned and the function will be exited! ");//
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