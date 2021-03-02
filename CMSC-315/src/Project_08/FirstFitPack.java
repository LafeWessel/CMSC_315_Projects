package Project_08;

public class FirstFitPack extends Packer{

	FirstFitPack(){
		super();
		type = "First Fit";
	}
	
	
	//Put Order into first Bin it fits in
	@Override
	public void pack() {
		long start = System.currentTimeMillis();

		for(Order o : orders) {
			packOrder(o);
			
		}
		//System.out.println(bins.toString());
		long end = System.currentTimeMillis();
		timeToPack = end-start;
	}
	
	private void packOrder(Order o) {
		//Find first open spot
		boolean added = false;
		//Add to Bin
		for (Bin b : bins) {
			if( o.size() <= b.getOpenSpace()) {
				b.addOrder(o);
				added = true;
				break;
			}
		}
		//No open bins
		if(!added) {
			Bin b = new Bin();
			b.addOrder(o);
			bins.add(b);	
		}

		
	}

}
