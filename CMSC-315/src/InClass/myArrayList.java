package InClass;

public class myArrayList<T> {
	T[] arr;
	int arraySize;
	int listSize;
	
	public myArrayList() {
		arr = (T[]) new Object[1];
	}
	
	public void add (T e) {
		if(listSize == arraySize) {
			doubleArraySize();
		}
		arr[listSize] = e;
		listSize++;
	}
	
	public void add(int i, T e) {
		if (listSize == arraySize) {
			doubleArraySize();
		}
		
		for(int j = arr.length; j > i; j--) {
			arr[j+1] = arr[j];
		}
		arr[i] = e;
		listSize++;
		
	}
	
	
	private void doubleArraySize() {
		T[] newArr = (T[]) new Object[arraySize * 2];
		
		for (int i = 0; i < listSize; i++) {
			newArr[i] = arr[i];
		}
		
		arraySize *= 2;
		arr = newArr;
	}
	
	
	public int size() {
		return listSize;
	}
	
	public T get(int i) {
		return arr[i];
	}
	
	
	public void clear() {
		
		for (int i = 0; i < listSize; i++) {
			arr[i] = null;
		}
		listSize = 0;
	}
	
	
	public boolean contains(T e) {
		for(int i =0; i < listSize; i++) {
			if(arr[i].equals(e)) {
				return true;
			}
			
		}
		return false;
	}
	
}
