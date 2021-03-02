package Project_06_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpellChecker {
	
	private Dictionary d;
	
	public SpellChecker(String dictionaryFile)
	{	
		System.out.println("Creating dictionary");
		d = new Dictionary(dictionaryFile);
	}
	public SpellChecker(String dictionaryFile, boolean debug)
	{	
		System.out.println("Creating dictionary");
		d = new Dictionary(dictionaryFile, debug);
	}
	
	//returns if word is in dictionary
	public boolean checkWord(String word) {
		return d.entryExists(word);
	}
	
	//adds word to dictionary
	public void addWordToDict(String word) {
		d.add(word);
	}
	
	//removes word from dict
	public void removeWordFromDict(String word) {
		d.remove(word);
	}
	
	public void checkDocument(String folderName, String fileName) {
		File fldr = new File(folderName);
		boolean fileFound = false;
		for(File f : fldr.listFiles()) {
			if(f.toString().contentEquals( folderName + fileName)) {
				fileFound = true;
				try {
					Scanner scr = new Scanner(f);
					Scanner in = new Scanner(System.in);
					String n = "";
					int c = 0;
					while(scr.hasNext()) {
						n = scr.next();
						if(!d.getBST().entryExists(new BSTEntry<String>(n))) {
							System.out.println(n + " not in dictionary:\n"
									+ "1: Add to dictionary\n"
									+ "2: continue without adding");
							c = in.nextInt();
							switch(c) {
							case 1:
								d.add(n);
								System.out.println("Added to dictionary");
								break;
							default:
								System.out.println("Continuing without adding");	
							}
						}
					}
					scr.close();
					in.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		if(!fileFound) {
			System.err.println("File not found: " + fileName);
		}
		System.out.println("Done spellchecking document");
		return;
	}
	
	public Dictionary getDict() {
		return d;
	}
	
}
