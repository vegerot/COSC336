public class PairsOfSums
{
	public int pairs(int[] nums, int t)
	{
		int result=0;
		int head=0;
		int tail=nums.length-1;
		int headCnt=1;
		int tailCnt=1;
		//O(n)
		//NOTE: While the large number of nested O(n)s may make it seem that this loop is >O(n) note that either these nested whiles either 1. Return immediately after (meaning the outer while is only evaluated once). Or 2. Move both the head and tail each time they run (meaning that both loops will run n times)
		while (head<tail)
		{
			if ((double)nums[head]==((double)t)/2)
                        {
				//O(n)
				//Returns immediately after, and runs ≤(tail-head) times
                                while (nums[head]==t/2)
                                {
                                        headCnt++;
                                        head++;
                                }
                                result+=(headCnt-1)*(headCnt-2)/2;
                                return result;
                        }
			else if ((double)nums[tail]==((double)t)/2)
                        {
				//O(n)
				//Returns immediately after, and runs ≤(tail-head) times
                                while (nums[tail]==t/2)
                                {
                                        tailCnt++;
                                        tail--;
                                }
                                result+=(tailCnt-1)*(tailCnt-2)/2;
                                return result;
                        }

			if (nums[head]+nums[tail]>t)
				tail--;
			else if (nums[head]+nums[tail]<t)
				head++;
			else
			{
				//O(n)
				//Increments head.  Meaning it does not add any additional pointer movements to outer while
				while (nums[head+1]==nums[head]&&head<tail)
				{
					headCnt++;
					head++;
				}
				//O(n)
				//Increments tail.  Meaning it does not add any additional pionter movements to outer while
				while (nums[tail-1]==nums[tail]&&head<tail)
				{
					tailCnt++;
					tail--;
				}
				
				result+=headCnt*tailCnt;
				head++;
				tail--;
				tailCnt=1;
				headCnt=1;
			}
		}
		
		return result;	

	}
}
