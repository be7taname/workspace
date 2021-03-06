package problemset;

import java.util.HashSet;

public class ContainsDuplicate {
	public boolean solution(int[] nums)
	{
		HashSet<Integer> hset = new HashSet<>();
		
		for (int num: nums) {
			if (!hset.add(num)) return true;
		}
		
		return false;
	}
}
