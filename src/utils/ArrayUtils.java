package utils;

import java.util.List;

public class ArrayUtils {
	public static <T extends Object> void swap(List<T> list, int i, int j) {
		T ith = list.get(i);
		list.set(i, list.get(j));
		list.set(j, ith);
	}
}
