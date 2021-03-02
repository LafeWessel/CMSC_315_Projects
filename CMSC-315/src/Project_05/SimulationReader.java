package Project_05;

import java.util.ArrayList;
import java.util.Scanner;

//This will read in the data for a given simulation and return the appropriate numbers

public class SimulationReader {
	
	public String description;
	private ArrayList<Double> vals;
	
	
	public SimulationReader()
	{	
		description = "";
	}
	
	public void readWords(Scanner s) {
		// Read in values from file
		
		ArrayList<Double> v = new ArrayList<Double>();
		
		while(s.hasNextDouble()) {
			v.add(s.nextDouble());
			//System.out.println(s.next());
		}
		description = s.nextLine() + s.nextLine();
		System.out.println(description + '\n');
		vals = v;
	}
	
	public double takeOffDur() {
		return vals.get(0);
	}
	public double landDur() {
		return vals.get(1);
	}
	public double depRate() {
		return vals.get(2);
	}
	public double arrRate() {
		return vals.get(3);
	}
	public double resFuelTime() {
		return vals.get(4);
	}
	public double simTime() {
		return vals.get(5);
	}

	public String toString() {
		return "Take off Duration: " + this.takeOffDur() + 
				"\nLanding Duration: " + this.landDur() + 
				"\nDeparture Rate: " + this.depRate() +
				"\nArrival Rate: " + this.arrRate() + 
				"\nReserve Fuel Time: " + this.resFuelTime() + 
				"\nSimulation Time: " + this.simTime() + '\n';
	}
	
	
}
