package problemset;

public class IsPowerOfTwo {
	public boolean solution(int n) {
        return ((n > 0) && ((n&(n-1)) == 0));		
	}
}
