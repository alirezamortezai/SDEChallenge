package datastructures.interafaces;

public interface MedianQueue<T extends Comparable<? super T>> {
	public  void insert(T item);
	public  T Remove();
	public  int size();
	public boolean isEmpty();
}
