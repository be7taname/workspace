package problemset;

public class MergeSortedArray {
	public void solution(int[] nums1, int m, int[] nums2, int n)
	{
		int idx2 = n-1, idx1 = m-1, wIdx = m + n - 1;
		
		while (idx2 >= 0 && idx1 >= 0) {
			if (nums1[idx1] < nums2[idx2]) {
				nums1[wIdx] = nums2[idx2];
				idx2--;
			} else {
				nums1[wIdx] = nums1[idx1];
				idx1--;
			}
			wIdx--;
		}
		if (idx2 >= 0) {
			for (int i = idx2; i >= 0; i--) {
				nums1[i] = nums2[i];
			}
		}
	}
}