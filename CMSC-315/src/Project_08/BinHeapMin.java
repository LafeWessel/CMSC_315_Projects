package Project_08;

import java.util.ArrayList;

//This class is a max heap that uses the Open Space of the Bin class as 
//the metric for arranging the heap

public class BinHeapMin {
	private ArrayList<Bin> heap;
	private int size;
	
	
	BinHeapMin(){
		size = 0;
		heap  = new ArrayList<Bin>();
	}
	
	
	
	public int size() {
		return size;
	}
	
	//Add a node to the Heap and filter up
	public void add(Bin b) {
		//System.out.println("Adding " + b.toString());
		heap.add(b);
		size++;
		int bi = size-1;
		
		//Swap upwards while parent is greater than added Bin
		while(heap.get(bi).compareTo(heap.get(parent(bi))) < 0) {
			swap(bi, parent(bi));
			bi = parent(bi);
		}
		
		
	}
	
	//Remove and return the greatest element
	public Bin pop() {
		Bin r = heap.get(0);
		size--;
		// sort the tree from the root node
		heap.set(0,heap.get(size));
		heap.remove(size);
		sort(0);
		
		return r;
	}
	
	public Bin peek() {
		return heap.get(0);
	}
	
	public Bin tailPeek() {
		return heap.get(size-1);
	}
	
	private void sort(int i) {	
		//recursively look at children of i, swap if need be
		
		//Don't walk off end of array
		if(isLeaf(i)) {
			return;
		}
		
		// if left greater than i
		if(heap.get(i).compareTo(heap.get(left(i))) > 0) {
            swap(i, left(i)); 
            sort(left(i)); 
		}
		
		// if right greater than i
		else if(heap.get(i).compareTo(heap.get(right(i))) > 0) {
            swap(i, right(i)); 
            sort(right(i)); 
		}
		
	}
	
	
	private int parent(int i) {
		return i / 2;
	}
	
	private int left(int i) {
		return i * 2;
	}
	
	private int right(int i) {
		return (i * 2) + 1;
	}
	
	private void swap(int from, int to) {
		Bin temp = heap.get(to);
		heap.set(to, heap.get(from));
		heap.set(from, temp);		
	}
	
	private boolean isLeaf(int i) {
        if (i >= (size / 2) && i <= size) { 
            return true; 
        } 
        return false; 
	}
	
	public String toString() {
		String out = "";
		for(Bin b : heap) {
			out += b.toString() + ",\n";
		}
		return out;
	}
	
	
}
