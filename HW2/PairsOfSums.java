public class PairsOfSums
{
	public pairs(int[] nums, int t)
	{
		int result[]=new int[];
		int head=0;
		int tail=nums.length;
		while (head>=0&&tail<=nums.length)
		{
			if (nums[head]+nums[tail]>target)
				tail--;
			else if (nums[head]+nums[tail]<target)
				head++;
			else break;
		}
		
		return {head,tail};	

	}
}
