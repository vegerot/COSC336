//Easier BUT WORSE
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
	}

	public boolean[] occurance(int[] list)
	{
		boolean third=false;
		boolean half=false;
		int random=randomElement(list);
		for (int i=0; i<list.length;i++)
		{
			int cntr=0;
			if (list[i]==random)
				cntr++;
			if (cntr>=Math.ceiling(list.length/3))
			{
				third=true;
				if (cntr>=Math.ceiling(list.length/2)
				{
					return {true,true};
				}
			}

		}
		return {third,false};
	}

	public int randomElement(int[] list)
	{
		return list[new Random().nextInt(list.length)];
	}
}
