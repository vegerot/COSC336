//This program reads files andturns the data into an array of arrays for the X and Y coordinates

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class fileParser
{
	private int[][] data;
	private int size;
	private int target;


	public fileParser(String filename)
	{
		parse(filename);
	}
	private void parse(String fn)
	{
		int[] ifFail=new int[1];
		ifFail[0]=1;
		try 
		{

			Scanner fileScanner=new Scanner(new File(fn));
			size=fileScanner.nextInt();
			data=new int[size][2];
			
			//O(n)
			for(int i=0;fileScanner.hasNextInt(); i++)
				for (int j=0; j<2; j++)
					data[i][j]=fileScanner.nextInt();

		} catch (FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
	}
	public int[][] getData()
	{
		return data;
	}
	public int getTarget()
	{
		return target;
	}

	/*public static void main(String[] args)
	{
		String basename="input-2.1.txt";

		String fn="../resources/"+basename;

		fileParser(basename);
	}*/

}
