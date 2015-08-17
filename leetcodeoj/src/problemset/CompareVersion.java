package problemset;

public class CompareVersion {
	public int solution(String version1, String version2)
	{
		String[] ver1 = version1.split("\\.");
		String[] ver2 = version2.split("\\.");
		
		int num1, num2;
		for (int i = 0; i < Math.max(ver1.length, ver2.length); i++) {
			if (i < ver1.length) num1 = Integer.valueOf(ver1[i]);
			else num1 = 0;
			if (i < ver2.length) num2 = Integer.valueOf(ver2[i]);
			else num2 = 0;
			if (num1 > num2) return 1;
			else if (num1 < num2) return -1;
		}
		return 0;
	}
	
	public void test() {
		solution("12.2.5", "4.22.1");
	}
}
