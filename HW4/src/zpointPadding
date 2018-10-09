/*This program piece converts a array of arrays into a histogram array so that the information can be fed through the given code and
*find the largest area in a histogram fassion.
*/
public class ZpointPadding
{
  public static int[] Padding(int[][] unpadded)
  {
    int[] padded=new int[unpadded[unpadded.length-1][0]];// makes it so the last X coordinate is the highest value of the 
								                                      	// new histogram array as their is no backtracking in the data sets
    int j = 0;
    for (int u=0, p=0; u < unpadded.length-1; u++)      //Converts the data inputs given into a histogram format with only 1 width squares
    {
      if (unpadded[u][0] != unpadded[u+1][0])
      {
        int difference = (unpadded[u+1][0]-unpadded[u][0]);
        int duplicate = unpadded[u][1];
        if (j < difference)
        {
          padded[p] = duplicate;
          p++;
          j++;
          u--;
        }
        else
        {
          if (j == difference)
          {
            j = 0;
          }
        }
      }
    }
    return padded;
  } 
}
