package problemset;

public class TrailingZeroes {
	public int solution(int n)
	{
		int num = 0, div = 5;
		
		n /= div;
		while (n > 0) {
			num += n;
			n /= div;
		}
		
		return num;
	}
}
