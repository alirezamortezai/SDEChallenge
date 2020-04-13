package datastructures;

import static org.junit.Assert.assertEquals;

import java.util.List;
import datastructures.interafaces.MedianQueue;

public class GenericMedianQueue<T extends Comparable<? super T>> implements MedianQueue<T> {

	MinHeap<T> minHeap;
	MaxHeap<T> maxHeap;

	
	public GenericMedianQueue() {
		this.minHeap  = new MinHeap<>();
		this.maxHeap  = new MaxHeap<>();
	}


	@Override
	public void insert(T item) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public T Remove() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<T> getMedian() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
