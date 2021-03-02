package Project_08;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestPacking {
	
	//This class tests the functionality of many of the classes
	//and methods in this app, but it does not run it as is required
	//by the project specifications
	
	public static void main(String[] args) {
		
		//Test that the OrderReader class can read in integers
		//And that the offset functionality works properly
		System.out.println("Offset 0, read 10 :");
		OrderReader or = new OrderReader();
		or.offset = 0;
		or.ordersToRead = 10;
		or.readOrders();
		System.out.println(or.getOrders().toString());
		
		System.out.println("Offset 3, read 10 :");
		or.offset = 3;
		or.ordersToRead = 10;
		or.readOrders();
		System.out.println(or.getOrders().toString());
		or.offset = 0;
		
		ArrayList<Order> o = or.getOrders();
		System.out.println(or.getOrders());
		
		//Test that a Bin can add correctly
		System.out.println("Test filling Bin");
		Bin b = new Bin();
		System.out.println(b.getOpenSpace());
		b.addOrder(o.get(0));
		System.out.println(b.getOpenSpace());
		System.out.println("Test overfilling Bin");
		b.addOrder(o.get(1));
		System.out.println(b.getOpenSpace());
		
		//test that bin can remove correctly
		System.out.println("Test removing from Bin");
		b.removeOrder(o.get(0));
		System.out.println(b.getOpenSpace());

		
		//Test various packing methods
		System.out.println("Orders for fit tests:");
		or.readOrders();
		System.out.println(or.getOrders());
				
		//First Fit
		System.out.println("First Fit");
		or.readOrders();
		//System.out.println(or.getOrders().toString());
		Packer p = new FirstFitPack();
		p.setOrders(or.getOrders());
		p.pack();
		System.out.println(p.toString());
		
		//Test BinHeap functionality
		System.out.println("Test BinHeapMin construction");
		BinHeapMin bh = new BinHeapMin();
		for(Bin bin : p.bins) {
			bh.add(bin);
		}
		System.out.println(bh.toString());
		
		System.out.println("Test BinHeapMin pop");
		System.out.println(bh.pop().toOutputString());
		System.out.println(bh.toString());
		
		
		//Test BinHeap functionality
		System.out.println("Test BinHeapMax construction");
		BinHeapMax bhm = new BinHeapMax();
		for(Bin bin : p.bins) {
			bhm.add(bin);
		}
		System.out.println(bhm.toString());
		
		System.out.println("Test BinHeapMax pop");
		System.out.println(bhm.pop().toOutputString());
		System.out.println(bhm.toString());
		
					
		//Worst Fit
		System.out.println("Worst Fit");
		or.readOrders();
		//System.out.println(or.getOrders().toString());
		p = new WorstFitPack();
		p.setOrders(or.getOrders());
		p.pack();
		System.out.println(p.toString());
		
		//Worst Fit Decreasing
		System.out.println("Worst Fit Decreasing");
		or.readOrders();
		//System.out.println(or.getOrders().toString());
		p = new WorstFitDecrPack();
		p.setOrders(or.getOrders());
		p.pack();
		System.out.println(p.toString());
		
		//Best Fit
		System.out.println("Best Fit");
		or.readOrders();
		//System.out.println(or.getOrders().toString());
		p = new BestFitPack();
		p.setOrders(or.getOrders());
		p.pack();
		System.out.println(p.toString());
		
		//Best Fit Decreasing
		System.out.println("Best Fit Decreasing");
		or.readOrders();
		//System.out.println(or.getOrders().toString());
		p = new BestFitDecrPack();
		p.setOrders(or.getOrders());
		p.pack();
		System.out.println(p.toString());

	}
	
	
	
	

}
