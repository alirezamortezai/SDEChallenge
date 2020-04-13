package datastructures;

import java.util.ArrayList;
import java.util.List;

import datastructures.interafaces.Heap;

public class MaxHeap<T extends Comparable<? super T>> implements Heap<T>{
	List<T> list;
	
	public MaxHeap() {
		this.list = new ArrayList<>();
	}

	@Override
	public void insert(T item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T examine() {
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

}
