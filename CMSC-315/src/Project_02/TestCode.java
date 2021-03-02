package Project_02;
import java.util.stream.IntStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class TestCode {
	
	//Change DIRECTORY to your directory in which your text files are located
	//Change TOPCOUNT to the top X words by count that you would like to display where X is the value of TOPCOUNT
	
	
	public static final String DIRECTORY = "C:\\Users\\Lafe Wessel - Laptop\\OneDrive\\Dordt\\2020 Fall\\CMSC 315\\JavaPrograms\\CMSC-315\\src\\Project_02\\txtFiles";
	public static final int TOPCOUNT = 20;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// read in files from DIRECTORY
		File txtFiles = new File(DIRECTORY);
		TextReader reader = new TextReader();
		
		// read words from each file
		for(File f : txtFiles.listFiles()) {
			
			System.out.println("Reading from: " + f.getName());
			try {
				Scanner s = new Scanner(f);	
				reader.readWords(s);
				s.close();
			}
			catch(FileNotFoundException e) {
				System.out.println("Cannot find file named: " + f.getName());
			}
			
			
		}
		
		// sort words
		System.out.println("\n\n\nSorting words\n\n\n");
		reader.sortByCount();
		
		//Find 20 most used
		System.out.println("Top "+TOPCOUNT+" Words by Count");
		for(int i = 0; i < TOPCOUNT; i++) {
			System.out.println((i+1) + " : \t" + reader.words.get(i).word + "\t\t" + reader.words.get(i).count);
		}

	}

}
