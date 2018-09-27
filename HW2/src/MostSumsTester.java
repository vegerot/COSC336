import java.util.Scanner;
public class MostSumsTester
{
	public static void main(String[] args)
	{
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
		
		//System.out.print("possible sums: ");
		//printArr(sums);
		
		sums=new MergeSort().mergeSortList(sums);

                //System.out.print("sorted sums: ");
		//printArr(sums);

		int answer=new MostSums().getMostSums(sums);

		System.out.println("The most common sum is: "+answer);

	}

	public static void printArr(int[] arr)
	{
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
		System.out.print("Input file here: ");
		Scanner cin=new Scanner(System.in);
		String file=cin.next();
		cin.close();
		return file;

	}
}
