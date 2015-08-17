package problemset;

public class IsAnagram {
	public boolean solution(String s, String t) {
		if (s.length() != t.length()) return false;
		
		while (s.length() != 0) {
			String ss = Character.toString(s.charAt(0));
			s = s.replace(ss, "");
			t = t.replace(ss, "");
			if (s.length() != t.length()) return false;
		}
		return true;
	}
	
	public void test() {
		String s = "anagrad";
		String t = "nagaram";
		
		System.out.println("Is " + s + " and " + t + " Anagram?: " + solution(s, t));
	}
}
