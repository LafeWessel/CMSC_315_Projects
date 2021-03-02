package Project_07;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextReader {
	public static String filePath = 
			"C:\\Users\\Lafe Wessel - Laptop\\OneDrive\\Dordt\\2020 Fall\\CMSC 315\\Project07\\";
	
	public static final int fullFile = 250000;
	public static final int partialFile = 5000;
	
	public TextReader() {
		
	}
	
	public static ArrayList<Comparable> readIntegers(String fileName, boolean full){
		ArrayList<Comparable> list = new ArrayList<Comparable>();
		
		File f = new File(filePath + fileName);
		try {
			int max = full ? fullFile : partialFile;
			int i = 0;
			Scanner sc = new Scanner(f);
			while(sc.hasNextInt() && i < max) {
				list.add(sc.nextInt());
				i++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.err.println("list.size: " + list.size());
		return list;
	}
}
