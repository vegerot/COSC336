public class PairsTester
{
	public static void main(String[] args)
	{
		//System.out.println(new pairs(mergeSortList(new SumParser("input-1.1.txt").getData())));
		SumParser inFile=new SumParser("input-1.1.txt");
		int[] input=inFile.getData();
		int target=inFile.getTarget();
		for (int i=0;i<input.length;i++)
                        System.out.print(input[i]+" ");
		System.out.println();
		int[] sorted=new MergeSort().mergeSortList(input);

		for (int i=0; i<sorted.length;i++)
			System.out.print(sorted[i]+" ");
		System.out.println();

		int result=new PairsOfSums().pairs(sorted,target);
		System.out.println(result);
	}
}
