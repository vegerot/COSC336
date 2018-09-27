/* Written by: Max Coplan, Zachary Kafka, Andrew Willingham, Sage Isaac
 * 
 * COSC 336-002
 * 
 * Zimand
 * 
 * Due 9/27/2018
 * 
 * This class calculates the most common sum found by adding elements in the array.
 * 
 * 
 * 
 * The most common sum is found by finding all possible sums, sorting them,
 * 
 * counting the number of times that each sum occurs, and returning the
 * 
 * sum with the highest count.
 * */




import java.util.Scanner;
public class MostSumsTester
{
  public static void main(String[] args)
  {
    //=======================================
    
    // Auto run main method
    
    //=======================================
    
    String file;
    if (args.length!=0)
      file=args[0];
    else
      file=getInput();
    SumParser2 test=new SumParser2(file);
    int[] data=test.getData();
    System.out.print("input data: "); 
    printArr(data);
    
    
    int[] sums=new Tuples().getSumOfPairs(data);
    
    sums=new MergeSort().mergeSortList(sums);
    
//    System.out.print("sorted sums: ");
  //  printArr(sums);

    int answer=new MostSums().getMostSums(sums);
    
    System.out.println("The most common sum is: "+answer);
  
  }

  public static void printArr(int[] arr)
  {
    //================================
    
    // Displays array
    
    //================================
    
    
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
}
