/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestsubsequence;


//import required packages
import java.util.Scanner;
//class LongestSubsequence
public class LongestSubsequence
{
    //function, note X is the list we are running through to find the longest subsequence 
    //P will store the location for the previous number in the final list for backtracking through the longest subsequence
    //L stores what part of the list we have looked at so far
    public static int[] lis(int[] X)
    {       
        int number = X.length;
        int[] M = new int[number];
        int[] P = new int[number];
        int L = 0;
        for (int i = 1; i < number; i++)
        {
            int j = 0;
          //search for elements
            for (int pos = L ; pos >= 1; pos--)
            {
                if (X[M[pos]] < X[i])
                {
                    j = pos;
                    break;
                }
            }           
            P[i] = M[j];
            if (j == L || X[i] < X[M[j + 1]])
            {
                M[j + 1] = i;
                //math funtion used to assign elements
                L = Math.max(L,j + 1);
            }
        }
        //backtracking process
        int[] result = new int[L];
        int pos = M[L];
        for (int i = L - 1; i >= 0; i--)
        {
            result[i] = X[pos];
            pos = P[pos];
        }
        return result;            
    }
  
    public static void main(String[] args)
    {   
        Scanner input = new Scanner(System.in);
        System.out.println("Longest Subsequence\n");
        System.out.println("Enter number of elements");
        int n = input.nextInt();
        int[] arr = new int[n + 1];
        System.out.println("\nEnter "+ n +" elements");
        for (int i = 1; i <= n; i++)
            arr[i] = input.nextInt();
        LongestSubsequence obj = new LongestSubsequence();
        int[] result = obj.lis(arr);      
       //printing values
        System.out.print("\nLongest Subsequence is: ");
        System.out.println("\nLength of increasing subsequence is:"+result.length);
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] +" ");
            
        System.out.println();
    }
}
/*
Test 1
8 in List
10 9 2 5 3 7 101 18

Test 2
50 in list
186  359  274  927  890  520  571  310  916  798  732  23  
196  579  426 188  524  991  91  150  117  565  993  615  
48  811  594  303  191  505  724  818  536  416  179  485   
334   74  998  100  197  768  421  114  739  636  356  908   
477  656

Test 3
50 in list
318   536   390   598   602   408   254   868   379   565
206   619   936   195   123   314   729   608   148   540
256   768   404   190   559   1000   482   141   26  230
550   881   759   122   878  350  756  82  562  897  508
853  317   380   807   23   506   98   757   247
*/