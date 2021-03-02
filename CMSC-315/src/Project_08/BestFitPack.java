package Project_08;

import java.util.ArrayList;

public class BestFitPack extends Packer{

	private BinHeapMin bh;
	
	BestFitPack(){
		super();
		bh = new BinHeapMin();
		type = "Best Fit";
	}
	
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
		//System.out.println("Packing Order " + o.toString());
		
		//If no bins have yet been added
		if(bins.size() <= 0) {
			Bin b = new Bin();
			b.addOrder(o);
			bins.add(b);
			bh.add(b);
		}
		
		//If bottom bin doesn't have enough room, none of them do
		else if(bh.tailPeek().getOpenSpace() < o.size()) {
			// create new bin
			Bin b = new Bin();
			b.addOrder(o);
			bh.add(b);
			bins.add(b);
		}
		
		else {
			//Add to bin with most remaining room
			// pop top bin until pop has enough room
			ArrayList<Bin> popped = new ArrayList<Bin>();
			while(bh.peek().getOpenSpace() < o.size()) {
				//System.out.println("O cant fit in " + bh.peek().toString());
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
		//System.out.println(bh.toString());
		
	}

}
