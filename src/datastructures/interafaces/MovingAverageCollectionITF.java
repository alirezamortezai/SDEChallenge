package datastructures.interafaces;

import java.util.List;


public interface MovingAverageCollectionITF<T extends Number> {
	public void add(T t);
	public List<T> getElements();
	public double getWindowAverage();

}
