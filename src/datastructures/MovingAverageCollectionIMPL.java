package datastructures;

import java.util.ArrayList;
import java.util.List;

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
		add(this.elements.size(), t);
	}

	@Override
	public List<T> getAll() {
		return new ArrayList<T>(this.elements);
	}

	@Override
	public double getWindowAverage() {
		return this.avg;
	}
	

	@Override
	public void add(int i, T t) {
		if (i < 0 || i > this.elements.size())
			throw new IndexOutOfBoundsException("index=" + i + ", size=" + this.elements.size());
		if(i > this.elements.size() - this.windowSize) {
			if(this.elements.size() >= this.windowSize) {
				double diff = t.doubleValue() - this.elements.get(this.elements.size() - this.windowSize).doubleValue();
				this.avg += diff/this.windowSize;
			}else {
				this.avg = (this.elements.size() * this.avg + t.doubleValue())/(this.elements.size() + 1);
			}
		}
		
		this.elements.add(i, t);
	}

	@Override
	public T get(int i) {
		return this.get(i);
	}

	@Override
	public T remove(int i) {
		if (i < 0 || i >= this.elements.size())
			throw new IndexOutOfBoundsException("index=" + i + ", size=" + this.elements.size());
		
		T t = this.elements.remove(i);
		
		if(i > this.elements.size() - this.windowSize) {
			if(this.elements.size() < this.windowSize) {
				this.avg = ((this.elements.size() + 1) * this.avg - t.doubleValue())/this.elements.size();
			}else {
				double diff =  this.elements.get(this.elements.size() - this.windowSize).doubleValue() - t.doubleValue() ;
				this.avg += diff/this.windowSize;
			}
			
		}
		return t; 
	}

	@Override
	public T remove() {
		return remove(0);
	}
	
	void printCalculatedAvg() {
		double sum = 0;
		int i = this.elements.size() - 1;
		int num = 0;
		int window = this.windowSize;
		
		while(i >= 0 && window > 0) {
			sum+=this.elements.get(i).doubleValue();
			num++;
			window--;
			i--;
		}
		System.out.println("real avg=" + sum/num);
	}
	
	public static void main(String[] args) {
		
		//test add when arr is larger than window
		MovingAverageCollectionIMPL<Integer> c1 = new MovingAverageCollectionIMPL<>(5);
		c1.add(1);
		c1.add(1);
		c1.add(3);
		c1.add(5);
		c1.add(0);
		c1.add(8);
		c1.add(9);
		System.out.println(c1.getAll().toString());
		System.out.println(c1.getWindowAverage());
		c1.printCalculatedAvg();
		
		
		//test add when arr is smaller than window
		MovingAverageCollectionIMPL<Integer> c2 = new MovingAverageCollectionIMPL<>(5);
		c2.add(1);
		c2.add(0);
		c2.add(5);
		System.out.println(c2.getAll().toString());
		System.out.println(c2.getWindowAverage());
		c2.printCalculatedAvg();
		
		
		//test remove when arr is larger than window
		MovingAverageCollectionIMPL<Integer> c3 = new MovingAverageCollectionIMPL<>(5);
		c3.add(1);
		c3.add(1);
		c3.add(3);
		c3.add(5);
		c3.add(0);
		c3.add(8);
		c3.add(9);
		c3.remove();
		System.out.println(c3.getAll().toString());
		System.out.println(c3.getWindowAverage());
		c3.printCalculatedAvg();
		
		//test remove when arr is smaller than window
		MovingAverageCollectionIMPL<Integer> c4 = new MovingAverageCollectionIMPL<>(5);
		c4.add(1);
    	c4.add(0);
		c4.add(5);
		c4.remove();
		System.out.println(c4.getAll().toString());
		System.out.println(c4.getWindowAverage());
		c4.printCalculatedAvg();
		
		
		//test add+index when boundary outside
		MovingAverageCollectionIMPL<Integer> c5 = new MovingAverageCollectionIMPL<>(5);
		c5.add(1);
		c5.add(1);
		c5.add(3);
		c5.add(5);
		c5.add(0);
		c5.add(8);
		c5.add(9);
		c5.add(2, 100);
		System.out.println(c5.getAll().toString());
		System.out.println(c5.getWindowAverage());
		c5.printCalculatedAvg();
		
		//test add+index when boundary inside
		MovingAverageCollectionIMPL<Integer> c6 = new MovingAverageCollectionIMPL<>(5);
		c6.add(1);
		c6.add(1);
		c6.add(3);
		c6.add(5);
		c6.add(0);
		c6.add(8);
		c6.add(9);
		c6.add(3, 99);
		System.out.println(c6.getAll().toString());
		System.out.println(c6.getWindowAverage());
		c6.printCalculatedAvg();
		
		//test remove+index when boundary outside
		MovingAverageCollectionIMPL<Integer> c7 = new MovingAverageCollectionIMPL<>(4);
		c7.add(1);
		c7.add(1);
		c7.add(5);
		c7.add(3);
		c7.add(7);
		c7.add(9);
		c7.remove(2);
		System.out.println(c7.getAll().toString());
		System.out.println(c7.getWindowAverage());
		c7.printCalculatedAvg();
		
		//test remove+index when boundary outside
		MovingAverageCollectionIMPL<Integer> c8 = new MovingAverageCollectionIMPL<>(4);
		c8.add(1);
		c8.add(1);
		c8.add(5);
		c8.add(3);
		c8.add(7);
		c8.add(9);
		c8.remove(1);
		System.out.println(c8.getAll().toString());
		System.out.println(c8.getWindowAverage());
		c8.printCalculatedAvg();
		
		
		
		
	}

}
