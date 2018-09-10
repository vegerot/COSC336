//import required packages
import java.util.Scanner;
//class LongestSubsequence
public class LongestSubsequence
{
    //function
    public int[] lis(int[] X)
    {       
        int number = X.length - 1;
        int[] M = new int[number + 1];
        int[] P = new int[number + 1];
        int L = 0;
        for (int i = 1; i < number + 1; i++)
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
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] +" ");
            System.out.println("\nLength of increasing subsequence is:"+result.length);
        System.out.println();
    }
}