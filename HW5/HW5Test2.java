import java.util.*;

public class HW5Test2
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
        if (number < 0 ) 
        {
          System.out.println("Number has to be 0 or greater. Try again: ");
        }
        else 
        {
          done = true;
        }
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
    int[] count = new int[array.length];
    int[] sums = new int[array.length];
    int[] highestLengthArray = new int[array.length];
    int highestLength = 0;
    for (int i = 0; i < count.length; i++)
    {
      count[i] = 1;
    }
    for (int i = 1; i < array.length; i++)
    {
      sums[i] = array[i];
      int currentHighest = 0;
      for (int j = 0; j < i; j++)
      {
        if (array[i] > array[j])
        {
          count[i] = count[j] + 1;
          
          if (array[j] > currentHighest)
          {
            currentHighest = array[j];
            sums[i] = sums[i] + array[j];
          }
        }
      }
      
      if (count[i] > highestLength)
        highestLength = count[i];
    }
    
    for (int i = 0; i < array.length; i++)
    {
      if (count[i] == highestLength)
        highestLengthArray[i] = count[i];
    }
    
    int highestTotal = 0;
    for (int i = 0; i < array.length; i++)
    {
      if (highestLengthArray[i] != 0)
      {
        if (sums[i] > highestTotal)
          highestTotal = sums[i];
      }
    }
    
    return highestTotal;
  }
}
