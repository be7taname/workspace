package problemset;

public class Rotate {
	public void solution(int[] nums, int k)
	{
		int len = nums.length;
		int[] tmp = new int[len];
		for (int i = 0; i < len; i++) {
			tmp[(i+k)%len] = nums[i];
		}
		for (int i = 0; i < len; i++) {
			nums[i] = tmp[i];
		}
	}
}
