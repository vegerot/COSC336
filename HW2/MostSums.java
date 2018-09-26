public class MostSums
{
	public static int getMostSums(int[] arr)
	{
		int Max=0;
		int currentCounter=1;
		int maxTarget=0;
		//efficiency=O(arr.length);
		for (int i=0; i<arr.length-1; i++)
		{
			
			if (arr[i+1]==arr[i])
			{
				currentCounter++;
//				System.out.println(arr[i+1]+" is equal to "+arr[i]+". "+currentCounter+" in a row");

			}
			else 
			{
				//System.out.println(arr[i+1]+" is not equal to "+arr[i]);
				if (currentCounter>Max)
				{
					Max=currentCounter;
					maxTarget=arr[i];
					//System.out.println("New max is "+Max);
				}
				currentCounter=1;
			}
		}
		return maxTarget;
	}
}
