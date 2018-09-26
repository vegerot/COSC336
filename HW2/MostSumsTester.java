public class MostSumsTester
{
	public static void main(String[] args)
	{
		SumParser test=new SumParser("input-2.6.txt");
                int[] data=test.getData();

                int[] sums=new Tuples().getSumOfPairs(data);
		
		sums=new MergeSort().mergeSortList(sums);

		int answer=new MostSums().getMostSums(sums);

		System.out.println(answer);

	}
}
