package problemset;

import java.util.Hashtable;

public class RomanToInt {
	public int solution(String s)
	{
		Hashtable<Character, Integer> roman = new Hashtable<>();
		roman.put('I', 1);
		roman.put('V', 5);
		roman.put('X', 10);
		roman.put('L', 50);
		roman.put('C', 100);
		roman.put('D', 500);
		roman.put('M', 1000);
		
		int a, cur, nxt;
		a = 0;
		cur = roman.get(s.charAt(0));
		for (int i = 0; i < s.length(); i++) {
			if (i == s.length() - 1) {
				a += cur;
			} else {
				nxt = roman.get(s.charAt(i + 1));
				if (cur < nxt) {
					a -= cur;
				} else {
					a += cur;
				}
				cur = nxt;
			}
		}
		return a;
	}
}