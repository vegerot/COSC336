//Easier BUT WORSE
import java.util.*;
public class EasierSolution
{
	public static String getInput()
  	{
    		//=================================

    		// Gets filename from user

    		//=================================


    		System.out.print("Input file here: ");
	        Scanner cin=new Scanner(System.in);
    		String file=cin.next();
    		cin.close();
    		return file;

 	}

	public static void main(String[] args)
	{
		String basename;
       		if (args.length!=0)
              		basename=args[0];
        	else
                	basename=getInput();
		int[] list=new fileParser(basename).getData();
		
		boolean[] occurances=occurance(list);

		for (int i=0; i<2; i++)
			System.out.println(occurances[i]);

	}

	public static boolean[] occurance(int[] list)
	{
		int tries=0;
		boolean third=false;
		boolean half=false;
	        int[] alreadyPicked=new int[list.length+1];

		for (int i=0; i<alreadyPicked.length; i++)
		{
			alreadyPicked[i]=Integer.MIN_VALUE;
		}

		int random=randomElement(list,alreadyPicked);

		
		alreadyPicked[tries]=random;

		while (tries<Math.ceil(2*list.length/3))
		//while (tries<list.length)
		{
			tries++;
			//System.out.println("tries: "+tries);
			System.out.println((float)tries/list.length);
			int cntr=0;	
			for (int i=0; i<list.length;i++)
			{
				//System.out.println("i: "+i);
				if (list[i]==random)
					cntr++;
				//System.out.println(cntr);
				if (cntr>Math.ceil(list.length/3))
				{
					//System.out.println("THIRD");
					third=true;
			//		System.out.println("THIRD");
					if (cntr>Math.ceil(list.length/2))
					{
						//System.out.println("HALF");
						return new boolean[]{true,true};
					}
				}

			}
			random=randomElement(list,alreadyPicked);
                        alreadyPicked[tries]=random;
			//System.out.println("tries: "+tries);
		}
		return new boolean[]{third,false};
	}

	public static int randomElement(int[] list, int[] alreadyPicked)
	{
		boolean success=true;
		int random;
		/*do
		{
			success=true;
			random=list[new Random().nextInt(list.length)];
			for (int i=0; i<alreadyPicked.length; i++)
			{
				System.out.println("Does "+random+" = "+alreadyPicked[i]+" = "+(random==alreadyPicked[i]));
				if (random==alreadyPicked[i])
				{	
					success=false;
				}	
			}
		} while (success==false);*/
		int tryCnt=0;
		System.out.println("Entering randomElement do");
		do 
		{
			tryCnt++;
			random=list[new Random().nextInt(list.length)];
		//	System.out.println("Is "+random+" in alreadyPicked?"+(elementOf(alreadyPicked, random)));
			if (tryCnt>=list.length) break;
		} while(elementOf(alreadyPicked,random));
		return random;
	}

	public static boolean elementOf(int[] list, int element)
	{
		for (int i=0; i<list.length; i++)
		{
			if (element==list[i])
				return true;
		}
		return false;
	}
}
