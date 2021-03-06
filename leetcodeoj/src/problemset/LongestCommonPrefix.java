package problemset;

public class LongestCommonPrefix {
	public String solution(String[] strs)
	{
		String prefix = new String("");
		if (strs.length == 0) return prefix;
		else if (strs.length == 1) return strs[0];
		
		int len = strs[0].length(), flag;
		for (int i = 1; i < strs.length; i++) {
			if (strs[i].length() < len) len = strs[i].length();
		}
		flag = 0;
		for (int i = 0; i < len; i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (c != strs[j].charAt(i)) {
					flag = 1;
					break;
				}
			}
			if (flag == 1) break;
			else {
				prefix = prefix + c;
			}
		}
		return prefix;
	}
}
