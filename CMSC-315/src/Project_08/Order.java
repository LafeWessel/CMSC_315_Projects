package Project_08;

public class Order implements Comparable{
	private int size;
	//Don't initialize to zero to make sure that mistakenly uninitialized
	//Orders won't be able to be infinitely added to a Bin
	Order(){ 
		size = 1;
	}
	
	Order(int s){
		size = s;
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		return size + "";
	}

	@Override // Assumes that o will always be an instance of Order
	public int compareTo(Object o) {
		if( !(o instanceof Order) ) {
			System.out.println("o not an Order, o is a(n) " + o.getClass().toString());
			throw new IllegalArgumentException();
		}
		int oi = Integer.parseInt(o.toString());
		
		if(size > oi) {
			return 1;
		}
		else if(size < oi) {
			return -1;
		}		
		return 0;
	}
}
