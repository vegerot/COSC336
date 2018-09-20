import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class txtToArray
{
	/*public static void main(String[] args)
	{
		File file=new File("input-1.1.txt");
		
		int[] result=array(file);
		
		for (int i=2;i<result.length;i++)
		{
			System.out.print(result[i]+" ");
		}
		System.out.println();
	}*/

	public static int[] array(File in)
	{
		int[] ifFail=new int[1];
		ifFail[0]=1;
		try 
		{Scanner fileScanner=new Scanner(in);
		int length=fileScanner.nextInt();
		int[] allInputs=new int[length+2];
		allInputs[0]=length;
		
		int i=1;
		while(fileScanner.hasNextInt())
		{
			allInputs[i]=fileScanner.nextInt();
			i++;
		}
		return allInputs;
		} catch (FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		return ifFail;
	}
}
