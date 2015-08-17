package problemset;

public class HammingWeight {
	public int solution(int n)
	{
		int num = 0;
		while (n != 0) {
			num++;
			n = n&(n-1);
		}
		return num;
	}
}
