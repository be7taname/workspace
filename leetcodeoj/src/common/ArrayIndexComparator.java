package common;

import java.util.Comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayIndexComparator implements Comparator<Integer>
{
	private static final Logger logger = LogManager.getLogger();
    private int[] array;

    public ArrayIndexComparator(int[] array)
    {
        this.array = array;
    }

    public Integer[] createIndexArray()
    {
    	Integer[] indexes = new Integer[array.length];
        for (int i = 0; i < array.length; i++)
        {
            indexes[i] = i; 
        }
        return indexes;
    }

	@Override
	public int compare(Integer index1, Integer index2) {
//		return compare(array[index1], array[index2]);
		return array[index1] < array[index2] ? -1 : array[index1] == array[index2] ? 0 : 1;
	}

//    @Override
//    public int compare(Integer index1, Integer index2)
//    {
//    	logger.debug("index_1 = " + index1 + ". , index2 = " + index2 + ".");
//    	logger.debug("array_1 = " + array[index1] + ". , array2 = " + array[index2] + ".");
//        return compare(array[index1], array[index2]);
//    }
}