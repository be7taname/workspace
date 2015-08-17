package problemset;

import java.util.HashSet;

public class ContainsNearbyDuplicate {
	public boolean solution(int[] nums, int k)
	{
		HashSet<Integer> hset = new HashSet<>();
		
		if (nums.length <= k + 1) {
			for (int num: nums) {
				if (!hset.add(num)) return true;
			}
		} else {
			for (int i = 0; i <= k; i++) {
				if (!hset.add(nums[i])) return true;
			}
			for (int i = k + 1; i < nums.length; i++) {
				hset.remove(nums[i-k-1]);
				if (!hset.add(nums[i])) return true;
			}
		}
		return false;
	}
}