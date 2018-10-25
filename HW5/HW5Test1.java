import java.util.*;

public class HW5Test1
{
  public static void main(String[] args)
  {
    System.out.println("Enter the desired number of elements:");
    Scanner scan = new Scanner(System.in);
    int numEle = getInt(scan);
    int[] list1 = new int[numEle + 1];
    System.out.println("\nEnter "+ numEle +" elements:");
    int num;
    //while loop allows user to enter elements seperated by a space
    
    for (int i = 0; i < numEle; i++)
    {
      //reorganized so num = came first then assigned the num to a spot that way it stopped asking for an extra datapoint
      num = getInt(scan);
      list1[i] = num;
    }
      
    //This code block prints the user's numbers
    System.out.println("Printing entered numbers:");
    for (int z = 0; z < list1.length - 1; z++)
      System.out.print(list1[z] + " ");
    System.out.println("Done.");
       
       
    int result = lis(list1);      
    //printing result
    System.out.println("Highest sum of an increasing subsequence: " + result);          
    System.out.println();
  }
  
  
  //The function checks the input from the user and determines if it is an integer and if so, then it checks if it is positive
  public static int getInt(Scanner scan) 
  {
    int number = 0;
    boolean done = false;
    while (!done) 
    {
      if(scan.hasNextInt())
      {
        number = scan.nextInt();
        done = true;
      }
      else
      {
        System.out.println("Not an integer. Try again.");
        scan.nextLine();
      }
    }
    return number;
  }
  
  public static int lis(int[] array)
  {
    int sum = 0;
    int highestSum = array[0];
    for (int i = 1; i < array.length; i++)
    {
      sum = array[i];
      int currentHigh = array[i];
      for (int j = i-1; j >=0; j--)
      {
        if (array[i] >= array[j] && array[j] <= currentHigh)
        {
          sum += array[j];
          currentHigh = array[j];
        }
      }
      
      if (sum > highestSum)
        highestSum = sum;
    }
    return highestSum;
  }
}
