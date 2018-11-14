import java.util.*;
public class LinkedTest
{
	public static void main(String[] args)
	{
		LinkedList<Integer[]> list[]=new LinkedList[5];
		list[0]=new LinkedList<Integer[]>();
		list[0].add(new Integer[] {1,2});
		list[1]=new LinkedList<Integer[]>();
		list[1].add(new Integer[] {3,4});

		for (int i=0; i<list.length; i++)
		{
			for (int j=0; j<list[i].size(); j++)
				System.out.println(list[i].get(j)[0]);
		}

	}
}
