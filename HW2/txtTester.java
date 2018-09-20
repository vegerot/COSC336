import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class txtTester
{
	public static void main(String[] args)
	{
		File file=new File("input-1.1.txt");
		txtToArray test=new txtToArray();
		int[] result=test.array(file);
		for (int i=2;i<result.length;i++)
                {       
                        System.out.print(result[i]+" ");
                }
	}
}
