package Project_07;

import java.util.ArrayList;
import java.util.Comparator;

public class TestSorting {
	
	public static ArrayList<Comparable> inOrder; //5k items
	public static ArrayList<Comparable> revOrder; //5k items
	
	public static void main(String[] args) {
		
		// Read in files
		// Sort each file
		//  - Use each algorithm for writing to file
		
		refresh();
		
		String part = "partially_ordered.txt";
		String r1 = "random1.txt";
		String r2 = "random2.txt";
	
		
		// Selection Sort
		System.out.println("Array\t\tStable\tTime\tCompares\tSwaps\tElements");
		
		System.out.println("Selection Sort:\tN");
		System.out.print("Partial: ");
		timeSorting(new SelectionSort(TextReader.readIntegers(part, false)));
		System.out.print("Random 1: ");
		timeSorting(new SelectionSort(TextReader.readIntegers(r1, false)));
		System.out.print("Random 2: ");
		timeSorting(new SelectionSort(TextReader.readIntegers(r2, false)));
		System.out.print("In Order: ");
		timeSorting(new SelectionSort(inOrder));
		System.out.print("Rev. Order: ");
		timeSorting(new SelectionSort(revOrder));
		refresh();
		
		// Insertion Sort
		System.out.println("Insertion Sort:\tY");
		System.out.print("Partial: ");
		timeSorting(new InsertionSort(TextReader.readIntegers(part, false)));
		System.out.print("Random 1: ");
		timeSorting(new InsertionSort(TextReader.readIntegers(r1, false)));
		System.out.print("Random 2: ");
		timeSorting(new InsertionSort(TextReader.readIntegers(r2, false)));
		System.out.print("In Order: ");
		timeSorting(new InsertionSort(inOrder));
		System.out.print("Rev. Order: ");
		timeSorting(new InsertionSort(revOrder));
		refresh();
		
		// Quick Sort
		System.out.println("Quick Sort:\tN");
		System.out.print("Partial: ");
		timeSorting(new QuickSort(TextReader.readIntegers(part, true)));
		System.out.print("Random 1: ");
		timeSorting(new QuickSort(TextReader.readIntegers(r1, true)));
		System.out.print("Random 2: ");
		timeSorting(new QuickSort(TextReader.readIntegers(r2, true)));
		System.out.print("In Order: ");
		timeSorting(new QuickSort(inOrder));
		System.out.print("Rev. Order: ");
		timeSorting(new QuickSort(revOrder));
		refresh();
		
		// Bubble Sort
		System.out.println("Bubble Sort:\tY");
		System.out.print("Partial: ");
		timeSorting(new BubbleSort(TextReader.readIntegers(part, false)));
		System.out.print("Random 1: ");
		timeSorting(new BubbleSort(TextReader.readIntegers(r1, false)));
		System.out.print("Random 2: ");
		timeSorting(new BubbleSort(TextReader.readIntegers(r2, false)));
		System.out.print("In Order: ");
		timeSorting(new BubbleSort(inOrder));
		System.out.print("Rev. Order: ");
		timeSorting(new BubbleSort(revOrder));
		refresh();
		
		// Merge Sort
		System.out.println("Merge Sort:\tY");
		System.out.print("Partial: ");
		timeSorting(new MergeSort(TextReader.readIntegers(part, true)));
		System.out.print("Random 1: ");
		timeSorting(new MergeSort(TextReader.readIntegers(r1, true)));
		System.out.print("Random 2: ");
		timeSorting(new MergeSort(TextReader.readIntegers(r2, true)));
		System.out.print("In Order: ");
		timeSorting(new MergeSort(inOrder));
		System.out.print("Rev. Order: ");
		timeSorting(new MergeSort(revOrder));
		refresh();
		
	}
	
	public static int timeSorting(Sort alg) {
		
		//System.out.println("\n" + alg.type + " : " + alg.elements.size());
		int timeStart = (int) System.currentTimeMillis();
		
		//System.out.println("Start time: " + timeStart);
		alg.sortList();
		
		int timeEnd = (int) System.currentTimeMillis();
		//System.out.println("End time: " + timeEnd);
		//System.out.print("Total milliseconds: " + (timeEnd - timeStart));
						
		System.out.print("\t\t" + (timeEnd - timeStart) + "\t" 
		+ alg.compares + "\t" + alg.swaps + "\t" + alg.elements.size());
		
		
		
		System.out.println();
		return (timeEnd - timeStart);
		
	}
	
	public static void refresh() {
		inOrder = new ArrayList<Comparable>();
		revOrder = new ArrayList<Comparable>();
		
		for(int i = 1 ; i <= 5000; i++) {
			inOrder.add(i);
		}
		for(int i = 5000; i > 0; i--) {
			revOrder.add(i);
		}
	}

}
