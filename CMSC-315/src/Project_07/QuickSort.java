package Project_07;

import java.util.List;

public class QuickSort extends Sort{

	public QuickSort(List<Comparable> list) {
		super(list);
		type = "Quick Sort";
	}

	@Override
	public void sortList() {
		realQuickSort(0, elements.size());
	}
	
	public int median(int a, int b, int c) {
		return(elements.get(a).compareTo(elements.get(b)) < 0 ? 
				(elements.get(b).compareTo(elements.get(c)) < 0 ? 
						b : elements.get(a).compareTo(elements.get(c)) < 0? c : a) :
							(elements.get(b).compareTo(elements.get(c)) > 0? b : 
								elements.get(a).compareTo(elements.get(c)) > 0 ? c : a));
	}
	
	public void realQuickSort(int offset, int len) {
		int middle = offset + (len >> 1);//bit-shifting by 1 is the same as dividing by 2
		int low = offset;
		int high = offset + len - 1;
		
		int pivot = median(low, middle, high);
		compares += 5;
		
		int p = offset;
		int q = offset + len - 1;
		while(true) {
			while(p <= q && elements.get(p).compareTo(elements.get(pivot)) < 0) {
				compares++;
				p++;
			}//end while
			while(q >= p && elements.get(q).compareTo(elements.get(pivot)) > 0) {
				compares++;
				q--;
			}//end while
			if(p > q) {
				break;
			}//end if
			
			swap(elements, p, q);
			p++;
			q--;
			
		}//end main while loop
		
		if(q + 1 - offset > 1) {
			realQuickSort(offset, (q + 1 - offset));
		}
		if(offset + len - p > 1) {
			realQuickSort(p, (offset + len - p));
		}
		
	}//end realQuickSort

}
