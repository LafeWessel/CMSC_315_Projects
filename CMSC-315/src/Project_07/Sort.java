package Project_07;

import java.util.List;

public abstract class Sort {
	List<Comparable> elements;
	String type;
	
	int compares;
	int swaps;
	
	public Sort(List<Comparable> list) {
		elements = list;
		swaps = 0;
		compares = 0;
	}
	
	public abstract void sortList();
	
	//Swaps an element between two indexes in a given list
	public void swap(List<Comparable> list, int from, int to) {
		swaps++;
		if(from > list.size()-1 || to > list.size()-1) {
			System.err.println("Attempted to swap out of list bounds");
			throw new IndexOutOfBoundsException();
		}
		Comparable temp = list.get(from);
		
		list.set(from, list.get(to));
		list.set(to, temp);
		
	}
	
}
