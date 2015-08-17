package problemset;

public class ClimbStairs {
	public int solutionRecur(int n)
	{
		if (n == 1) return 1;
		else if (n == 2) return 2;
		else {
			return solutionRecur(n-1) + solutionRecur(n-2);
		}
	}

	public int solutionIter(int n) // faster solution
	{
		int last, curr, next = 0;
		if (n == 1) return 1;
		else if (n == 2) return 2;
		else {
			last = 1; 
			curr = 2;
			for (int i = 3; i <= n; i++) {
				next = curr + last;
				last = curr;
				curr = next;
			}
			return next;
		}
	}
	
	public void test()
	{
		int n = 44;
		System.out.println(solutionRecur(n));
		System.out.println(solutionIter(n));
	}
}
