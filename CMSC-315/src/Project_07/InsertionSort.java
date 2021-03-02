package Project_07;

import java.util.List;

public class InsertionSort extends Sort {

	public InsertionSort(List<Comparable> list) {
		super(list);
		type = "Insertion Sort";
	}

	@Override
	public void sortList() {
		//public static void insertionSort(int[] x) {
		
		for( int i = 0 ; i < elements.size(); i++) {
			int j = i;
			while( j>= 1 && j < elements.size() &&elements.get(j).compareTo(elements.get(j - 1)) < 0) {
				compares++;
				swap(elements, j, j-1);
				j--;
			}
		}
	}

}
