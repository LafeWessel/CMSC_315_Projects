package InClass;

import java.util.LinkedList;

public class MyHashTable {
	
	LinkedList<String>[] hashTable;
	int size; // # items in hashTable
	
	public static final float capacity_factor = 0.75f;
	
	public MyHashTable() {
		
		hashTable = new LinkedList[2];
		size = 0;
		for (int i = 0; i < hashTable.length; i++) {
			hashTable[i] = new LinkedList<String>();
		}
	}
	
	// Returns true only if s was successfully added to the hashTable
	public boolean add(String s) {
		
		int code = s.hashCode();
		if(hashTable[code % hashTable.length].contains(s)) {
			return false;
		} else {
			hashTable[code % hashTable.length].add(s);
			size++;
			if( size / hashTable.length > capacity_factor) {
				resize();
			}
			return true;
		}
	}
	
	
	private void resize() {
		
	}
	
}
