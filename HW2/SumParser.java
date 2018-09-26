import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class SumParser
{
	private int[] data;
	private int size;
	private int target;


	public SumParser(String filename)
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
//uncomment this for program 1			
			target=fileScanner.nextInt();
			data=new int[size];
			
			//O(n)
			for(int i=0;fileScanner.hasNextInt(); i++)
			{
				data[i]=fileScanner.nextInt();
			}

		} catch (FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
	}
	public int[] getData()
	{
		return data;
	}
	public int getTarget()
	{
		return target;
	}
}
