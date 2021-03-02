package Project_06_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary {
	
	private BinaryST<String> dict;
	public boolean debug;
	
	public Dictionary(String fileLoc){
		System.out.println("Creating BST");
		debug = false;
		dict = readWords(fileLoc);
		
	}
	
	public Dictionary(String fileLoc, boolean debug){
		System.out.println("Creating BST");
		this.debug = debug;
		dict = readWords(fileLoc);
		dict.debug = debug;
	}
	
	
	private BinaryST<String> readWords(String fileLoc) {
		
		if(debug) System.out.println("Reading words in from file");
		
		BinaryST<String> bst = new BinaryST<String>();
		
		bst.debug = debug;
		
		File f = new File(fileLoc);
		Scanner s;
		try {
			s = new Scanner(f,"UTF-8");
			int total = 0;
			while(s.hasNext()) {
				String n = s.next();
				BSTEntry<String> e = new BSTEntry<String>(n);
				bst.add(e);
				total++;
				
				if(total %1000 == 0) {
					System.out.println(total);
				}
				//System.out.println("Word added to bst:" + n);
			}
			s.close();
			
			if(debug) System.out.println("Total Words read in: " + total);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return bst;
	}
	
	public boolean entryExists(String word) {
		return dict.entryExists(new BSTEntry<String>(word));
	}
	
	public void add(String word) {
		dict.add(new BSTEntry<String>(word));
	}
	
	public void remove(String word) {
		dict.remove(new BSTEntry<String>(word));
	}
	
	public void print() {
		dict.print();
	}
	
	public BinaryST<String> getBST(){
		return dict;
	}
	
	
}
