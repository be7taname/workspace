package problemset;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountAndSay {
	private static final Logger logger = LogManager.getLogger();
    public String solutionRecursive(int n) {
    	if (n == 1) {
    		return "1";
    	} else if (n == 2) {
    		return "11";
    	} else {
    		String prev = solutionRecursive(n-1), next = "";
    		int count = 1;
    		char v1 = prev.charAt(0), v2;
    		for (int i = 1; i < prev.length(); i++) {
    			v2 = prev.charAt(i);
    			if (v1 == v2) {
    				count++;
    				if (i == prev.length()-1) {
    					next += String.valueOf(count);
        				next += v1;
    				}
    			} else {
					next += String.valueOf(count);
    				next += v1;
    				v1 = v2;
    				count = 1;
    				if (i == prev.length()-1) {
    					next += String.valueOf(count);
        				next += v1;
    				}
    			}
    		}
    		return next;
    	}
    }
    public String cas(String str) {
    	int cnt = 1;
//    	logger.debug(str);
    	char letter = str.charAt(0);
    	String str1 = "";
    	int i;
    	
    	for (i = 1; i < str.length(); i++) {
    		if (letter == str.charAt(i)) {
    			cnt++;
    		} else {
    			str1 += String.valueOf(cnt);
    			str1 += letter;
    			letter = str.charAt(i);
    			cnt = 1;
    		}
    	}
		if (i == str.length() && letter == str.charAt(i-1)) {
			str1 += String.valueOf(cnt);
			str1 += letter;
		}
    	
    	return str1;
    }
    public String solutionLoop(int n) {
    	String str1, strn = "";
    	
    	if (n == 1) strn = "1";
    	else {
    		str1 = "1";
    		for (int i = 1; i < n; i++) {
    			strn = cas(str1);
    			str1 = strn;
    		}
    	}
    	return strn;
    }
    
    public void test()
    {
    	long time1, time2, time3, timediff1, timediff2;
    	time1 = System.nanoTime();
    	solutionRecursive(10);
		//System.out.println(cas.solution(10));
		time2 = System.nanoTime();
		solutionLoop(10);
		//System.out.println(cas.solution2(10));
		time3 = System.nanoTime();
		timediff1 = time2 - time1;
		timediff2 = time3 - time2;
		System.out.println("Elapsed ns of method Rcrv is " + timediff1);
		System.out.println("Elapsed ns of method Loop is " + timediff2);
    }
}
