package Project_07;

import java.util.List;

public class BubbleSort extends Sort{

	public BubbleSort(List<Comparable> list) {
		super(list);
		type = "Bubble Sort";
	}

	@Override
	public void sortList () {
		int finalSwapPos = elements.size() - 1,
		swapPos;
		while (finalSwapPos > 0) {
			swapPos = 0;
			for (int i = 0; i < finalSwapPos; i++)
			if (elements.get(i).compareTo(elements.get(i + 1)) > 0){
				compares++;
				swap (elements, i, i + 1);
				swapPos = i;
			}
		finalSwapPos = swapPos;
		}
	}
}
