import java.util.*;

public class Tuples
{
	public static int[] getSumOfPairs(int[] input)
	{
		int[] sums=new int[input.length*input.length/2-input.length/2];
		int pos=0;
		for (int i=0; i<input.length; i++)
		{
			for (int j=i+1; j<input.length; j++,pos++)
			{
				sums[pos]=input[i]+input[j];
			}
				
		}
		return sums;
	}

	public static void main(String[] args)
	{
		SumParser test=new SumParser("input-2.1.txt");
		int[] data=test.getData();

		int[] sums=getSumOfPairs(data);

		for (int i=0; i<sums.length; i++)
		{
			System.out.print(sums[i]+" ");
		}
		System.out.println();
	}
}
