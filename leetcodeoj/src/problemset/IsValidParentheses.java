package problemset;

import java.util.Stack;

public class IsValidParentheses {
	public boolean solution(String s)
	{
		Stack<Character> paren = new Stack<>();
		
		char c, d;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if ((c == '(') || (c == '[') || (c == '{')) {
				paren.push(c);
			} else {
				if (paren.empty()) return false;
				d = paren.pop();
				if (c == ')') {
					if (d != '(') return false;
				} else if (c == ']') {
					if (d != '[') return false;
				} else if (c == '}') {
					if (d != '{') return false;
				}
			}
		}
		if (paren.empty()) return true;
		else return false;
	}
}
