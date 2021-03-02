package Project_07;

import java.util.List;

public class SelectionSort extends Sort{

	
	public SelectionSort(List<Comparable> list) {
		super(list);
		type = "Selection Sort";
	}

	@Override
	public void sortList () {
	// Make x [0 . . . i] sorted and <= x [i + 1] . . .x [x.length –1]:
		for (int i = 0; i < elements.size() - 1; i++) {
			int pos = i;
			for (int k = i + 1; k < elements.size(); k++) {
				if (elements.get(k).compareTo(elements.get(pos)) < 0) {
					compares++;
					pos = k;
				}	
			}
		swap(elements, i, pos);
		} // for i
	} // method selectionSort

}
