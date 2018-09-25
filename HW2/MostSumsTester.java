public class MostSumsTester
{
	public static void main(String[] args)
	{
		SumParser test=new SumParser("input-2.1.txt");
                int[] data=test.getData();

                int[] sums=new Tuples().getSumOfPairs(data);
		
		sums=new MergeSort().mergeSortList(sums);

                for (int i=0; i<sums.length; i++)
                {
                        System.out.print(sums[i]+" ");
                }
                System.out.println();
	}
}
