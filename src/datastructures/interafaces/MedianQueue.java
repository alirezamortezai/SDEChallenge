package datastructures.interafaces;

import java.util.List;

public interface MedianQueue<T extends Comparable<? super T>> {
	// adds element T to the head of the MedianQueue
	public  void insert(T item);
	// removes and returns the tail element T from the MedianQueue. It will return null if the MedianQueue is empty
	public  T Remove();
	// returns the current number of the elements in the MedianQueue
	public  int size();
	// returns true if there are currently no elements in the MedianQueue and false otherwise
	public boolean isEmpty();
	// returns a List containing:
	//     1- one element as the median if there are odd number of elements in the MedianQueue
	//     2- two elements as the median if there are even number of elements in the MedianQueue
	//     3- no elements if there are even no elements in the MedianQueue
	public List<T> getMedian();
}
