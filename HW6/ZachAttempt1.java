//Please note that this file has not yet been tested and was done on an online compiler as a practice attempt.
//This doesn't work yet because I didn't sort it T_T

import java.util.*;

public class HelloWorld
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
          
    //printing result
    
    
    if (NumOverThird(list1))
      System.out.println("YES");
    else
      System.out.println("NO");
    
    if (NumOverHalf(list1))
      System.out.println("YES");
    else
      System.out.println("NO");
    
    
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
  
  public static boolean NumOverThird(int[] a)
  {
    int counter = 1;
    int highestCount = 0;
    for (int i = 1; i < a.length; i++)
    {
      if (a[i] == a[i-1])
        counter++;
      else
        counter = 1;
      
      
      if (counter > highestCount)
      {
        highestCount = counter;
      }
    }
      
    if (highestCount > (a.length / 3))
      return true;
      
    return false;
  }
  
  public static boolean NumOverHalf(int[] a)
  {
    int counter = 1;
    int highestCount = 0;
    for (int i = 1; i < a.length; i++)
    {
      if (a[i] == a[i-1])
        counter++;
      else
        counter = 1;
      
      
      if (counter > highestCount)
      {
        highestCount = counter;
      }
    }
      
    if (highestCount > (a.length / 2))
      return true;

    return false;
  }
}
