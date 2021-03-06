package problemset;

public class LengthOfLastWord {
	public int solution(String s)
	{
		int i, j, cnt;
		int lastIndex = s.lastIndexOf(' ');
		int strLen = s.length();
		if (lastIndex != strLen - 1) {
			return strLen - lastIndex - 1;
		} else {
			for (i = strLen - 2; i >= 0; i--) {
				if (s.charAt(i) != ' ') break;
			}
			if (i >= 0) {
				cnt = 1;
				for (j = i - 1; j >= 0; j--) {
					if (s.charAt(j) != ' ') cnt++;
					else break;
				}
				return cnt;
			} else return 0;
		}
	}
	
	public void test() {
		System.out.println(solution("hello world"));
	}
}
