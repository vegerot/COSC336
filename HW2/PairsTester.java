public class PairsTester
{
	public static void main(String[] args)
	{
		//System.out.println(new pairs(mergeSortList(new SumParser("input-1.1.txt").getData())));
		SumParser inFile=new SumParser("input-1.1.txt");
		int[] input=inFile.getData();
		int target=inFile.getTarget();
		int[] sorted=new MergeSort().mergeSortList(input);


		int result=new PairsOfSums().pairs(sorted,target);
		System.out.println(result);
	}
}
