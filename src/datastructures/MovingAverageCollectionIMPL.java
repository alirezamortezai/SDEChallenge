package datastructures;

import java.util.ArrayList;
import java.util.List;

import com.sun.jdi.DoubleValue;

import datastructures.interafaces.MovingAverageCollectionITF;;

public class MovingAverageCollectionIMPL<T extends Number> implements  MovingAverageCollectionITF<T>{
	
	List<T> elements;
	int windowSize;
	double avg;
	
	public MovingAverageCollectionIMPL(int windowSize) throws IllegalArgumentException{
		if(windowSize < 1)
			throw new IllegalArgumentException("windowSize must be greater then or equal to 1");
		this.elements = new ArrayList<>();
		this.windowSize = windowSize;
		this.avg = 0;
	}

	@Override
	public void add(T t) {
		if(this.elements.size() >= this.windowSize) {
			double diff = t.doubleValue() - this.elements.get(this.elements.size() - this.windowSize).doubleValue();
			this.avg += diff/this.windowSize;
		}else {
			this.avg = (this.elements.size() * this.avg + t.doubleValue())/(this.elements.size() + 1);
		}
		this.elements.add(t);
	}

	@Override
	public List<T> getElements() {
		return new ArrayList<T>(this.elements);
	}

	@Override
	public double getWindowAverage() {
		return this.avg;
	}
	
	
	
	public static void main(String[] args) {
		MovingAverageCollectionIMPL<Integer> c1 = new MovingAverageCollectionIMPL<>(5);
		c1.add(1);
		c1.add(1);
		c1.add(1);
		c1.add(1);
		c1.add(1);
		c1.add(1);
		c1.add(1);
		c1.add(3);
		c1.add(5);
		c1.add(0);
		c1.add(8);
		c1.add(9);
		System.out.println(c1.getWindowAverage());
		
		
		
		MovingAverageCollectionIMPL<Integer> c2 = new MovingAverageCollectionIMPL<>(5);
		c2.add(1);
		c2.add(0);
		c2.add(5);
		System.out.println(c2.getWindowAverage());
		
	}

}
