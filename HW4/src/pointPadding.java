public class pointPadding
{
	public static int[] Padding(int[][] unpadded)
	{
		int[] padded=new int[unpadded[unpadded.length-1][0]]; //is this the right size?  I get zeroes at the end of padded

		for (int u=0, p=0; u<unpadded.length-1; u++)
		{
                	if (unpadded[u][0]!=unpadded[u+1][0])
			{
				int difference=(unpadded[u+1][0]-unpadded[u][0]);
				int duplicate=unpadded[u][1];
			        //System.out.println("differene: "+difference+" duplicate: "+duplicate);

                        	for (int j=0;j<difference; j++,p++)
                        	{
				//	System.out.println("u: "+unpadded[u][0]+" p: "+padded[p]+" j: "+j);
                                	padded[p]=duplicate;
					//System.out.println("padded= "+padded[p]);
                        	}

			}

		}
		return padded;
	}	

	public static void main(String[] args)
	{
		int[][] points=new int[][]{{3, 0}, {3, 1}, {4, 1}, {4, 3}, {6, 3}, {6, 6}, {10, 6}, {10, 
  2}, {13, 2}, {13, 5}, {17, 5}, {17, 1}, {18, 1}, {18, 8}, {20, 
  8}, {20, 0}};
		int[] padded=Padding(points);
		for (int i=0; i<padded.length;i++)
		{
			System.out.print(padded[i]+", ");
		}
		System.out.println();
	}
}
