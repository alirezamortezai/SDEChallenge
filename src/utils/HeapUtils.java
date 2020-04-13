package utils;

import java.util.List;

public class HeapUtils {
	public static <T extends Comparable<? super T>> void maxHeapify(List<T> list, int size, int i) {
		int lcIdx = i * 2 + 1; 
		int rcIdx = i * 2 + 2; 
		int largest = i;
		
		if (lcIdx < size && list.get(largest).compareTo(list.get(lcIdx)) < 0) {
			largest = lcIdx;
		}
		
		if (rcIdx < size && list.get(largest).compareTo(list.get(rcIdx)) < 0) {
			largest = rcIdx;
		}
		
		if (i != largest) {
			ArrayUtils.swap(list, largest, i);
			maxHeapify(list, size, largest);
		}
	}
	
	public static <T extends Comparable<? super T>> void minHeapify(List<T> list, int size, int i) {
		int lcIdx = i * 2 + 1; 
		int rcIdx = i * 2 + 2; 
		int smallest = i;
		
		if (lcIdx < size && list.get(smallest).compareTo(list.get(lcIdx)) > 0) {
			smallest = lcIdx;
		}
		
		if (rcIdx < size && list.get(smallest).compareTo(list.get(rcIdx)) > 0) {
			smallest = rcIdx;
		}
		
		if (i != smallest) {
			ArrayUtils.swap(list, smallest, i);
			minHeapify(list, size, smallest);
		}
	}

}
