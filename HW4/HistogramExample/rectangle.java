import java.util.*;
import java.lang.*;
import java.io.*;

class rectangle
{
	public static void main (String[] args) 
	{
		int origStart=0;
		int end=1;
		int height=arr[origStart];
		int maxArea=height;
		int area;
		while (origStart<arr.length)
		{
			height=arr[start];

			if (arr[start]>=arr[start+1])
                        {
                                area=height*(length);
                                if (area>maxArea)
                                        maxArea=area;
				length++;

                        }
			
			if (arr[length+origStart]<=arr[length+origStart+1])
			{
				int l=0;
				height=arr[start];
				for (int l;arr[start+l]>=arr[start]&&start+l<arr.length;l++);
				area=height*(l+origStart);
				start+=l;
			}
			origStart++;
		}
	}

	public static int nextBig(int[] arr; int s)
	{
		int l;
		for (int l;arr[s+l]>=arr[s]&&s+l<arr.length;l++);
		return l;
	}

	public static int nextLess(int[] 
}
