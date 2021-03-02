package Project_08;

import java.util.ArrayList;

//This contains the various packing methods
//that are used to sort the Orders into Bins

public abstract class Packer {
	
	protected ArrayList<Bin> bins;
	protected ArrayList<Order> orders;
	public String type;
	
	protected long timeToPack;
	
	
	Packer(){
		bins = new ArrayList<Bin>();
		orders = new ArrayList<Order>();
		type = "";
		timeToPack = -1;
	}
	
	Packer(ArrayList<Order> o){
		bins = new ArrayList<Bin>();
		orders = o;
		type = "";
		timeToPack = -1;
	}

	public void setOrders(ArrayList<Order> o) {
		orders = o;
	}
	
	public long getPackTime() {
		return timeToPack;
	}
	
	public String getType() {
		return type;
	}
	
	public float averageBinFill() {
		double total = 0.0;
		for(Bin b : bins) {
			total += b.getOpenSpace();
		}
		return (float) (100*((1000 - (total/bins.size())) / 1000));
	}
	
	abstract void pack();
	
	public String toString() {
		String out = type + "\n";
		for(Bin b : bins) {
			out += b.toOutputString() + ",\n";
		}
		return out;
	}
	
}
