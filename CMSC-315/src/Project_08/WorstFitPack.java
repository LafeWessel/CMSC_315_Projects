package Project_08;

import java.util.ArrayList;

public class WorstFitPack extends Packer{

	private BinHeapMax bh;

	WorstFitPack(){
		super();
		bh = new BinHeapMax();
		type = "Worst Fit";
		
	}
	
	//Put new order in Bin with most remaining room
	
	@Override
	public void pack() {
		long start = System.currentTimeMillis();

		for( Order o : orders) {
			packOrder(o);
		}
		long end = System.currentTimeMillis();
		timeToPack = end-start;		
	}
	
	private void packOrder(Order o) {
		
		//If no bins have yet been added
		if(bins.size() <= 0) {
			Bin b = new Bin();
			b.addOrder(o);
			bins.add(b);
			bh.add(b);
			return;
		}
		
		//If top bin doesn't have enough room, none of them do
		if(bh.peek().getOpenSpace() < o.size()) {
			// create new bin
			Bin b = new Bin();
			b.addOrder(o);
			bh.add(b);
			bins.add(b);
			return;
		}
		
				
		//Add to bin with most remaining room
		// pop top bin until pop has enough room
		ArrayList<Bin> popped = new ArrayList<Bin>();
		while(bh.peek().getOpenSpace() < o.size()) {
			popped.add(bh.pop());
		}
		Bin pop = bh.pop();
		pop.addOrder(o);
		
		bh.add(pop);
			
		//Add popped bins back to the BinHeap
		for(Bin b : popped) {
			bh.add(b);
		}
		
	}
	

}
