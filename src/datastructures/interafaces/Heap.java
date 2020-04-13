package datastructures.interafaces;

public interface Heap<T extends Comparable<? super T>> {
	public  void insert(T item);
	public T remove();
	public T examine();
	public  int size();
	public boolean isEmpty();
}
