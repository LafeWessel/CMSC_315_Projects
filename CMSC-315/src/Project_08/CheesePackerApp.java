package Project_08;

public class CheesePackerApp {

	public static final boolean DEBUG = false;
	
	public static void main(String[] args) {
		// test each algorithm with 10,100,2500,50000 orders
		
		testAlgorithms(10);
		testAlgorithms(100);
		testAlgorithms(2500);
		testAlgorithms(50000);
				
		System.out.println("End of program");
	}
	
	
	
	public static void testAlgorithms(int orders) {
		test(new WorstFitPack(), orders);
		test(new WorstFitDecrPack(), orders);
		test(new BestFitPack(), orders);
		test(new BestFitDecrPack(), orders);
		test(new FirstFitPack(), orders);
		
	}
	
	public static void test(Packer p, int orders) {
		OrderReader or = new OrderReader();
		or.offset = 0;
		or.ordersToRead = orders;
		or.readOrders();
		
		
		p.setOrders(or.getOrders());
		p.pack();
		
		System.out.println(p.getType() + " with " + orders + " orders");
		System.out.println("Took: " + p.timeToPack + " milliseconds");
		System.out.println("Average fill: " + p.averageBinFill() + " %");
		
		if(DEBUG) {
			System.out.println(p.toString());
		}
		System.out.println("");
	}
	
}
