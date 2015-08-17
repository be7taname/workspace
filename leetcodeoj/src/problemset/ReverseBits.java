package problemset;

public class ReverseBits {
	public int solution(int n)
	{
		for (int i = 0; i < 16; i++) {
			if ((((n>>i)&1) ^ ((n>>(31-i))&1)) == 1) {
				n ^= ((1<<i) | (1<<(31-i)));
			}
		}
		return n;
	}
}
