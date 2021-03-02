package Project_06_2;

import java.util.Scanner;

public class TestBST {
	//public static final String USER = "Lafe Wessel - Laptop";
	public static final String USER = "wesse";
	
	public static final String dictName = "engmixLarge.txt";
	//public static final String dictName = "words.txt";
	//public static final String dictName = "shuffled.txt";
	
	public static final String dictLoc = 
	"C:\\Users\\" + USER + "\\OneDrive\\Dordt\\2020 Fall\\CMSC 315\\JavaPrograms\\CMSC-315\\src\\Project_06\\dataFiles\\" + dictName;
	
	public static final String txtFolder = 
	"C:\\Users\\" + USER + "\\OneDrive\\Dordt\\2020 Fall\\CMSC 315\\JavaPrograms\\CMSC-315\\src\\Project_06\\dataFiles\\";

	public static final boolean DEBUG = false;
	
	public static Scanner scr = new Scanner(System.in);
	
	public static SpellChecker sc;
	
	public static void main(String[] args) {
		
		System.out.println("Creaing spellchecker");
		
		sc = new SpellChecker(dictLoc, DEBUG);
		//sc.getDict().print();
		
		System.out.println("Size: " + sc.getDict().getBST().size);
		System.out.println("Root.height: " + sc.getDict().getBST().root.height);
		System.out.println("Root size: " + sc.getDict().getBST().root.size);
		
		while(getNextChoice()) {
			
		}
		
		scr.close();
		System.out.println("Program terminated");
	}
	
	public static boolean getNextChoice() {
		System.out.println("Would you like to:\n"
				+ "1: Add a word to the dictionary\n"
				+ "2: Remove a word from the dictionary\n"
				+ "3: Spellcheck a file\n"
				+ "4: exit/quit\n"
				+ "5: print current dictionary\n"
				+ "Enter your number:");
		int option = scr.nextInt();
		
		switch(option) {
		case 1:
			addWord();
			break;
		case 2:
			removeWord();
			break;
		case 3:
			spellCheckFile();
			break;
		case 4:
			return false;
		case 5:
			if(sc.getDict().getBST().size > 50) {
				System.err.println("Can't print dictionary: too large!");
			}
			else {
				sc.getDict().print();
			}
			break;
		default:
			System.err.println("Invalid option, try again");
			getNextChoice();
		}
		return true;
		
	}
	
	public static void addWord() {
		System.out.println("Please enter word to add to dictionary:");
		String s = scr.next();
		
		System.out.println("Adding " + s + " to dictionary");
		sc.addWordToDict(s);
	}
	
	public static void removeWord() {
		System.out.println("Please enter a word to remove from dictionary:");
		scr = new Scanner(System.in);
		String s = scr.next();
		
		System.out.println("Removing " + s + " from dictionary");
		
		sc.removeWordFromDict(s);
	}
	
	public static void spellCheckFile() {
		System.out.println("Please enter the name of the file that you would like to spellcheck:");
		scr = new Scanner(System.in);
		String s = scr.next();
		sc.checkDocument(txtFolder, s);
	}
	
}
