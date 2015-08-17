package problemset;

public class MyAtoi {
	public int solution(String str)
	{
		int s;
        if (str.length() == 0) return 0;
		
		String trimStr = str.trim();
		
		int c0 = trimStr.charAt(0);
		if (!((c0 >= '0' && c0 <= '9') || (c0 == '+') || (c0 == '-'))) return 0;
		if (c0 == '-') s = 1;
		else s = 0;

		if ((c0 == '+') || (c0 == '-')) {
			trimStr = trimStr.substring(1);
		}

		int num = Character.getNumericValue(trimStr.charAt(0));
		if ((num < 0) || (num > 9)) return 0;
		for (int i = 1; i < trimStr.length(); i++) {
			int d = Character.getNumericValue(trimStr.charAt(i));
			if (d >= 0 && d <= 9) {
				if (i > 9) {
					num = 2147483647 + s;
					break;
				} else if ((i == 9) && ((num > 214748364 + s) || ((num == 214748364) && (d > 7 + s)))) {
					num = 2147483647 + s;
					break;
				} else {
					num *= 10;
					num += d;
				}
			} else break;
		}
		
		if (c0 == '-') num = -num;
		
		return num;
		
	}
	
	public void test()
	{
		System.out.println(solution("-abc"));
	}
}