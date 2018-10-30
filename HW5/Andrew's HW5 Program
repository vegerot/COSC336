import java.util.*;

/* Dynamic Programming Java 
implementation of Maximum Sum 
Increasing Subsequence (MSIS) 
problem */
public class HWAssignment5 { 
  
   // Driver code 
 public static void main(String args[]) { 
  int arr[] = new int[]{41, 18467, 6334, 26500, 19169, 15724, 11478, 29358, 26962, 24464}; 
  int n = arr.length; 
  System.out.println("Sum of maximum sum " + "increasing subsequence is " + maxSumIS(arr, n)); 
 }
 /* maxSumIS() returns the 
 maximum sum of increasing 
 subsequence in arr[] of size n */
 static int maxSumIS(int arr[], int n) { 
  int i, j, max = 0; 
  int msis[] = new int[n]; 

  /* Initialize msis values 
  for all indexes */
  for (i = 0; i < n; i++) 
   msis[i] = arr[i]; 

  /* Compute maximum sum values 
  in bottom up manner */
  for (i = 1; i < n; i++) 
   for (j = 0; j < i; j++) 
    if (arr[i] > arr[j] && 
     msis[i] < msis[j] + arr[i]) 
     msis[i] = msis[j] + arr[i]; 

  /* Pick maximum of all 
  msis values */
  for (i = 0; i < n; i++) 
   if (max < msis[i]) 
    max = msis[i]; 

  return max; 
 } 
} 
