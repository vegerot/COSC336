import java.util.*;
import java.lang.*;

public class test3HW2Part2
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please input the total number of desired elements.");
    int totalNum = scan.nextInt();//getInt(scan);
    System.out.println("Please input each element delimited by a space.");
    int[] array1 = new int[totalNum];
    for (int i = 0; i < totalNum; i++)
    {
      //reorganized so num = came first then assigned the num to a spot that way it stopped asking for an extra datapoint
      int num = 0;
      int userInput = scan.nextInt(); //getInt(scan)
      num = userInput;
      array1[i] = num;
    }
    
    
    System.out.println("Best count is: " + count(array1));
    
  }
  public static int count(int[] a) 
  {
    int bestCount = 0;
    int bestIndexValue = 0;
    
    MeSort(a);
    
    boolean negativeCheck = false;
    
    for (int i = 0; i < a.length; i++)
    {
      if (a[i] < 0)
      {
        negativeCheck = true;
        break;
      }
    }
    
    
    int sumsLength = 0;
    if (negativeCheck)
    {
      sumsLength = Math.max((Math.abs(a[0] + a[1]) + 1),(a[a.length - 1] + a[a.length - 2] + 1));
      
      sumsLength = sumsLength * 2;
    }
    else
      sumsLength = (a[a.length - 1] + a[a.length - 2] + 1);
    int[] sums = new int[sumsLength];
    
    int sum = 0;
    
    for (int i = 0; i < a.length; i++)
    {
      for (int j = i + 1; j < a.length; j++)
      {
        sum = a[i] + a[j];
        if (negativeCheck)
        {
          if (sum >= 0)
          {
            sum = a[i] + a[j];
            sums[sum + (sumsLength / 2)] += 1;
          }
          else
          {
            if (sum < 0)
            {
              sums[-sum] += 1;
            }
          }
        }
        else
        {
          sum = a[i] + a[j];
          sums[sum] += 1;
        }
      }
    }
    
    for (int i = 0; i < sums.length; i++)
    {
      if (bestCount < sums[i])
      {
        bestCount = sums[i];
        bestIndexValue = i;
      }
    }
    
    if (negativeCheck)
    {
      if (bestIndexValue >= (sumsLength / 2))
        bestIndexValue -= (sumsLength / 2);
      else
        bestIndexValue = -1 * bestIndexValue;
    }
    
    if (negativeCheck)
    {
      for (int i = 0; i < sums.length; i++)
      {
        if (i < (sumsLength / 2))
          System.out.println("Sums[" + (-i) + "]: " + sums[i]);
        else
          System.out.println("Sums[" + (i - (sumsLength / 2)) + "]: " + sums[i]);
      }
    }
    else
    {
      for (int i = 0; i < sums.length; i++)
      {
        System.out.println("Sums[" + i + "]: " + sums[i]);
      }
    }
    
    return bestIndexValue;
  }

public static void MeSort(int[] a)
{
  MeSort(a, 0, a.length - 1);
  
}
public static void MeSort(int[] a, int min, int max)
{
  if (min < max)
  {
      int mid = min - ((min - max) / 2); //(min + max) / 2;
      MeSort(a, min, mid);
      MeSort(a, mid + 1, max);
      merge(a, min, mid, max);
  }
}
  public static void merge(int[] a, int first, int mid, int last)
  {
    int[] temp = new int[a.length];
    
    int first1 = first, last1 = mid;
    int first2 = mid+1, last2 = last;
    int index = first1;
    
    while (first1 <= last1 && first2 <= last2)
    {
      if (a[first1] < a[first2])
      {
        temp[index] = a[first1];
        first1++;
      }
      else
      {
        temp[index] = a[first2];
        first2++;
      }
      index++;
    }
    
    while (first1 <= last1)
    {
      temp[index] = a[first1];
      first1++;
      index++;
    }
    while (first2 <= last2)
    {
      temp[index] = a[first2];
      first2++;
      index++;
    }
    
    for (index = first; index <= last; index++)
      a[index] = temp[index];
  }
}