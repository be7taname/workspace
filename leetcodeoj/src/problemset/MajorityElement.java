package problemset;

import java.util.Arrays;
import java.util.Hashtable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MajorityElement {
	private static final Logger logger = LogManager.getLogger();
    private static int N;
    /* Sort Function */
    public static void sort(int arr[])
    {       
        heapify(arr);        
        for (int i = N; i > 0; i--)
        {
            swap(arr,0, i);
            N = N-1;
            maxheap(arr, 0);
        }
    }
    /* Function to build a heap */   
    public static void heapify(int arr[])
    {
        N = arr.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(arr, i);        
    }
    /* Function to swap largest element in heap */        
    public static void maxheap(int arr[], int i)
    { 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])        
            max = right;
 
        if (max != i)
        {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }    
    /* Function to swap two numbers in an array */
    public static void swap(int arr[], int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp; 
    }    
    
    public int solutionSort(int[] nums) 
    {
    	//sort(nums);
    	//logger.debug(Arrays.toString(nums));
    	Arrays.sort(nums);
    	return nums[nums.length/2];
    }
    
    public int solutionHash(int[] nums) 
    {
    	Hashtable<Integer, Integer> counter = new Hashtable<Integer, Integer>(nums.length*2);
    	int old_value;
    	
    	if (nums.length >= 2) {
	    	for (int i = 0; i < nums.length; i++) {
	    		if (counter.containsKey(nums[i])) {
	    			old_value = counter.get(nums[i]);
	        		if (old_value >= nums.length/2) {
	        			return nums[i];
	        		}
	    			counter.put(nums[i], old_value + 1);
	    		} else {
	    			counter.put(nums[i], 1);
	    		}
	    	}
    	} else {
    		return nums[0];
    	}
    	
    	return -1;
    }
    
    public int solutionMoore(int[] nums)
    {
    	int count, candidate;
    	
    	candidate = nums[0]; count = 1;
    	for (int i = 1; i < nums.length; i++) {
    		if (nums[i] == candidate) {
    			count++;
    		} else {
    			if (count == 1) {
    				candidate = nums[i];
    			} else {
    				count--;
    			}
    		}
    		if (count > nums.length - 1 - i) {
    			break;
    		}
    	}
    	
    	return candidate;
    }
    
    public int solutionBit(int[] nums)
    {
    	int num0, num1, value;
    	
    	value = 0;
    	for (int i = 0; i < 32; i++) {
    		num1 = 0;
    		num0 = 0;
    		for (int j = 0; j < nums.length; j++) {
    			//logger.debug("nums[" + j + "] = " + nums[j] + ". And the LSB is " + (nums[j]&1));
    			if ((nums[j]&1) == 1) {
    				num1++;
    			} else {
    				num0++;
    			}
    			nums[j] >>= 1;
    		}
    		//logger.debug("num1 = " + num1 + ", num0 = " + num0 + ".");
    		if (num1 > num0) {
    			value ^= (1 << i);
    		}
    	}
    	
    	return value;
    }
    
    public void test()
    {
    	long time1, time2, time3, time4, time5, timediff1, timediff2, timediff3, timediff4;
    	int[] vvv = new int[] {3, 4, 3, 4, 3, 2, 4, 3, 3, 3, 1, 3};

    	time1 = System.nanoTime();
    	solutionHash(vvv);
    	//System.out.println(me.solutionHash(vvv));
		time2 = System.nanoTime();
    	solutionSort(vvv);
    	//System.out.println(me.solutionSort(vvv));
		time3 = System.nanoTime();
		solutionMoore(vvv);
    	//System.out.println(me.solutionMoore(vvv));
		time4 = System.nanoTime();
		solutionBit(vvv);
    	//System.out.println(me.solutionBit(vvv));
		time5 = System.nanoTime();
		timediff1 = time2 - time1;
		timediff2 = time3 - time2;
		timediff3 = time4 - time3;
		timediff4 = time5 - time4;
		System.out.println("Elapsed ns of method Hash is " + timediff1);
		System.out.println("Elapsed ns of method Sort is " + timediff2);
		System.out.println("Elapsed ns of method Moor is " + timediff3);
		System.out.println("Elapsed ns of method bit  is " + timediff4);
    }
}
