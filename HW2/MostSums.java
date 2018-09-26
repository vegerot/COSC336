public class MostSums
{
	public static int getMostSums(int[] arr)
	{
		int Max=0;
		int currentCounter=1;
		for (int i=0; i<arr.length-1; i++)
		{
			
			if (arr[i+1]==arr[i])
				currentCounter++;
			else 
			{
				if (currentCounter>Max)
					Max=currentCounter;
				currentCounter=1;
			}
		}
		return Max;
	}
}
