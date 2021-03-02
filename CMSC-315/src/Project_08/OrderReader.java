package Project_08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class OrderReader {
	
	public static final String filePath = "C:\\Users\\wesse\\OneDrive\\Dordt"
			+ "\\2020 Fall\\CMSC 315\\Project08\\";
	public static final String fileName = "cheese_order_sizes.txt";
	
	public int ordersToRead;
	public int offset;
	private ArrayList<Order> orders;
	
	OrderReader(){
		ordersToRead = 0;
		offset = 0;
		orders = new ArrayList<Order>();
	}
	OrderReader(int toRead, int off){
		ordersToRead = toRead;
		offset = off;
		orders = new ArrayList<Order>();
	}
	
	public ArrayList<Order> getOrders(){
		return orders;
	}
	
	public void readOrders() {
		
		orders = new ArrayList<Order>();
		File f = new File(filePath + fileName);
		
		try {
			Scanner sc = new Scanner(f);
			
			//Iterate through offset
			for( int i = 0; i < offset; i++) {
				sc.next();
			}
			
			//Add ints to LL of integers
			for (int i = 0; i < ordersToRead; i++) {
				if(sc.hasNextInt()) {
					orders.add(new Order(sc.nextInt()));
				}
				else {
					System.out.println("SC does not have next int");
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find order file!");
			e.printStackTrace();
		}
	}
	
	
}
