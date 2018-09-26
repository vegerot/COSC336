import java.util.Scanner;

public class PairsTester
{
	public static void main(String[] args)
	{
		//System.out.println(new pairs(mergeSortList(new SumParser("input-1.1.txt").getData())));
                String file;
                if (args.length!=0)
                        file=args[0];
                else
                        file=getInput();
                SumParser inFile=new SumParser(file);
	       	int[] input=inFile.getData();
                System.out.print("input data: ");
                printArr(input);

		int target=inFile.getTarget();
		int[] sorted=new MergeSort().mergeSortList(input);


		int result=new PairsOfSums().pairs(sorted,target);
		System.out.println(result);
	}

	public static String getInput()
        {
                System.out.print("Input file here: ");
                Scanner cin=new Scanner(System.in);
                String file=cin.next();
                cin.close();
                return file;

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

}
