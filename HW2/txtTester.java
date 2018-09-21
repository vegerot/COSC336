import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class txtTester
{
	public static void main(String[] args)
	{
		SumParser test=new SumParser("input-1.1.txt");
		int[] result=test.getData();
		int target=test.getTarget();
		for (int i=0;i<result.length;i++)
                {       
                        System.out.print(result[i]+" ");
                }
	}
}
