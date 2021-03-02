package Project_08;

import java.util.Collections;

public class BestFitDecrPack extends BestFitPack{

	BestFitDecrPack(){
		super();
		type = "Best Fit Decreasing";
	}
	
	@Override
	public void pack() {
		
		long start = System.currentTimeMillis();
		// sort orders into decreasing order then super().sort()
		Collections.sort(orders, Collections.reverseOrder());
		
		super.pack();
		long end = System.currentTimeMillis();
		timeToPack = end-start;
	}

}
