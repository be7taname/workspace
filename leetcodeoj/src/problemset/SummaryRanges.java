package problemset;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public List<String> solution(int[] nums) {
		List<String> range = new ArrayList<>();
		
		if (nums.length == 0) return range;
		int curStart, curEnd;
		curStart = nums[0];
		curEnd = nums[0];
		String thisRange;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - curEnd == 1) {
				curEnd = nums[i];
			} else {
				if (curStart == curEnd) {
					thisRange = String.valueOf(curStart);
				} else {
					thisRange = String.format("%d->%d", curStart, curEnd);
				}
				range.add(thisRange);
				curStart = nums[i];
				curEnd = nums[i];
			}
		}
		if (curStart == curEnd) {
			thisRange = String.valueOf(curStart);
		} else {
			thisRange = String.format("%d->%d", curStart, curEnd);
		}
		range.add(thisRange);
		
		return range;
	}
	
	public void test()
	{
		int[] nums = {0, 1, 2, 4, 5, 7};
		
		System.out.println(solution(nums));
	}
}
