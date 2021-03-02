package Project_06_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestSpellChecker {
	
	public static final boolean DEBUG = false;
	
	public static void main(String[] args) {
		
		SpellChecker sc = new SpellChecker(TestBST.dictLoc, DEBUG);
		
		
		File f = new File(TestBST.dictLoc);
		ArrayList<BSTEntry<String>> words = new ArrayList<BSTEntry<String>>();
		
		//Add words to array list of entries
		try {
			Scanner scn = new Scanner(f,"UTF-8");
			while(scn.hasNext()) {
				words.add(new BSTEntry<String>(scn.next()));
			}			
			scn.close();

		} catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("SpellChecker size: " + sc.getDict().getBST().size);
		System.out.println("ArrayList size: " + words.size());
		
		for(BSTEntry<String> b : words) {
			if(!sc.checkWord(b.element)) {
				System.err.println(b.element + " is not in spellchecker!");
			}	
		}
		
			
		System.out.println("ArrayList[0]: " + words.get(0).element);
		System.out.println("ArrayList[end]: " + words.get(words.size()-1).element);
		
		//sc.getDict().print();
		
		ArrayList<BSTEntry<String>> arr = new ArrayList<BSTEntry<String>>();
		sc.getDict().getBST().arrayFromTree(arr, sc.getDict().getBST().root);
		
		//System.out.println(arr.toString());
		
		System.err.println("Done with verification");
				
	}
	
	
	
}
