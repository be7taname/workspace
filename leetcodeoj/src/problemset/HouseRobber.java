package problemset;

public class HouseRobber {
	public int solution(int[] nums)
	{
		int len = nums.length, newmax = 0;
		
		if (len == 1) return nums[0];
		else if (len == 2) return Math.max(nums[0], nums[1]);
		else if (len == 0) return 0;
		else {
			int max1 = nums[0], max2 = Math.max(nums[0], nums[1]);
			for (int i = 2; i < len; i++) {
				newmax = Math.max(max2, max1 + nums[i]);
				max1 = max2;
				max2 = newmax;
			}
			return newmax;
		}
	}
}