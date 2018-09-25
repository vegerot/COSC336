public class PairsOfSums
{
	public pairs(int[] nums, int t)
	{
		int result=0;
		int head=0;
		int tail=nums.length-1;
		int headCnt=1;
		int tailCnt=1;
		while (head<tail)
		{
			if (nums[head]+nums[tail]>target)
				tail--;
			else if (nums[head]+nums[tail]<target)
				head++;
			else
			{
				while (nums[head+1]==nums[head]&&head!=tail)
				{
					headCnt++;
					head++;
				}
				while (nums[tail-1]==nums[tail]&&head!=tail)
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
