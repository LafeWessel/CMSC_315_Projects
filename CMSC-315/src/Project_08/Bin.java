package Project_08;

import java.util.ArrayList;

public class Bin implements Comparable{
	public static final int capacity = 1000;
	
	private int openSpace;
	ArrayList<Order> orders;
	
	Bin(){
		openSpace = capacity;
		orders = new ArrayList<Order>();
	}
	
	
	public void addOrder(Order o) {
		if( o.size() > openSpace) {
			System.out.println("Can't add to Bin, too little space!");
		}
		else {
			orders.add(o);
			recalcOpen();
		}
	}
	
	//returns if the order was removed from the array
	public boolean removeOrder(Order o) {
		boolean removed = orders.remove(o);
		recalcOpen();
		return removed;
	}
	
	public int getOpenSpace() {
		return openSpace;
	}
	
	public int getNumOrders(){
		return orders.size();
	}
	
	//Recalculate open space in the array
	private void recalcOpen() {
		openSpace = capacity;
		for(Order o : orders) {
			openSpace -= o.size();
		}
	}
	
	public String toOutputString() {
		return "Open Space: " + openSpace + 
				", Orders: " + orders.toString();
				
	}
	
	public String toString() {
		return openSpace + "";
	}
	
	@Override // Assumes that o will always be an instance of Order
	public int compareTo(Object o) {
		if( !(o instanceof Bin) ) {
			System.out.println("o not an Order, o is a(n) " + o.getClass().toString());
			throw new IllegalArgumentException();
		}
		int oi = Integer.parseInt(o.toString());
		
		if(openSpace > oi) {
			return 1;
		}
		else if(openSpace < oi) {
			return -1;
		}		
		return 0;
	}
}
