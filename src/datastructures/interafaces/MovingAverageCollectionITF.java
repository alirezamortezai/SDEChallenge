package datastructures.interafaces;

import java.util.List;


public interface MovingAverageCollectionITF<T extends Number> {
	public void add(T t);
	public void add(int i, T t);
	public List<T> getAll();
	public T get(int i);
	public T remove(int i);
	public T remove();
	public double getWindowAverage();

}
