/* Written by: Max Coplan, Zachary Kafka, Andrew Willingham, Sage Isaac
 * 
 * COSC 336-002
 * 
 * Zimand
 * 
 * Due 9/27/2018
 * 
 * This class calculates the largest number of element pairs that equal a user-defined target
 * 
 * 
 * 
 * This class finds the largest number of element pairs by first sorting the array,
 * 
 * using a Merge Sort (of time Complexity (O(n log n))). After sorting the array, it begins
 * 
 * to start viewing the elements from both ends of the array. Several variables are used to keep track
 * 
 * of everything including an overall result variable, an index for the first element being viewed
 * 
 * called head, an index for the last element being viewed called tail, and counter variables specific
 * 
 * to both of the previously specified indices. This program only continues to  move throughout the 
 * 
 * array while the head, is less than the tail. If the sum of the head and tail elements
 * 
 * is greater than the target, then the tail index is decreased by 1. If the sum is less than the
 * 
 * target, then the head index is increased by 1. If the sum is equal to the target, then the 
 * 
 * program checks to see if the next value of head or tail is equal to the current value. This is
 * 
 * done for the purpose of detecting duplicate numbers; if the next value in the array is equal to 
 * 
 * the previous value (in either head or tail), then the value of head and its counter variable are both
 * 
 * increased by 1. The product of both counter variables is added to the result variable, the counter
 * 
 * variables are reset to 1 and head is incremented by 1 while tail is decremented by 1. This is done 
 * 
 * repeatedly until either the value at the index of head or the value at the index of tail is equal to
 * 
 * half of the target. This is because the array is sorted and if the value at head is greater than half
 * 
 * of the target, no tail value beyond that point would add up to the target when added to the value at head.
 * 
 * If the value at the head is equal to half of the target, then the program increases the value of head and
 * 
 * its counter variable by 1 until the value of the array at head is no longer equal to the half the target. 
 * 
 * The program then adds the summation of the head counter variable to the result variable and returns the
 * 
 * result. If the value at the tail is equal to half of the target, then the program decreases the
 * 
 * value of head by 1 and increases its counter variable by 1 until the array at tail is no longer equal
 * 
 * to half of the target. The program then adds the summation of the tail counter variable to the overall
 * 
 * result and returns the overall result. If neither indices have an element that is equal to half of the
 * 
 * target, then the program continues looping until head becomes greater than or equal to tail, at which
 * 
 * point, the loop stops and returns the result.
 * */






import java.util.Scanner;

public class PairsTester
{
 public static void main(String[] args)
 {
   //=====================================
   
   // Auto run main method
   
   //=====================================
   
   String file;
   if (args.length!=0)
     file=args[0];
   else
     file=getInput();
   SumParser1 inFile=new SumParser1(file);
   int[] input=inFile.getData();
   System.out.print("input data: ");
   printArr(input);

   int target=inFile.getTarget();
   int[] sorted=new MergeSort().mergeSortList(input);

   
   int result=new PairsOfSums().pairs(sorted,target);
   System.out.println(result);
 }

 public static String getInput()
 {
   
   //===================================
   
   // Gets filename for input from user
   
   //===================================
   
   System.out.print("Input file here: ");
   Scanner cin=new Scanner(System.in);
   String file=cin.next();
   cin.close();
   return file;
   
 }

 public static void printArr(int[] arr)
 {
   //===================================
   
   // Displays array
   
   //===================================
   
   if (arr.length<20)
     for (int i=0; i<arr.length; i++)
     System.out.print(arr[i]+" ");
   else
   {
     for (int i=0; i<8; i++)
       System.out.print(arr[i]+" ");
     System.out.print("...");
     for (int i=arr.length-8; i<arr.length;i++)
       System.out.print(arr[i]+" ");
   }
   System.out.println();
 }

}