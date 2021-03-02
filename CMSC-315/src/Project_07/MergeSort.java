package Project_07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort extends Sort{

	public static final int MERGE_THRESHOLD = 7;
	
	ArrayList<Comparable> elements;
	
	
	public MergeSort(ArrayList<Comparable> list) {
		super(list);
		type = "Merge Sort";
		elements = list;
	}

	@Override	
	public void sortList() {
		ArrayList<Comparable> y = new ArrayList<Comparable>();
		
		for(Comparable t : elements) {
			y.add(t);
		}
		
		realMergeSort(y, elements, 0, elements.size());
	}
	
	private void realMergeSort(ArrayList<Comparable> src, ArrayList<Comparable> dst, int low, int high) {
		int length = high - low;
		
		if(length <= MERGE_THRESHOLD) { //Insertion sort for small inner portions of the array
			for(int i = low; i < high; i++) {
				for(int j = i; j > low && dst.get(j-1).compareTo(dst.get(j)) > 0; j--) {
					compares++;
					swap(dst, j, j-1);
				}
			}
			return;
		}
		int middle = (low + high) / 2;
		realMergeSort(dst, src, low, middle);
		realMergeSort(dst, src, middle, high);
		
		int p = low;
		int q = middle;
		for(int i = low; i < high; i++) {
			if(q >= high || (src.get(p).compareTo(src.get(q)) <= 0 && p < middle)) {
				dst.set(i, src.get(p));
				p++;
			}else {
				dst.set(i,src.get(q));
				q++;
			}
			compares++;
		}
	}
}
