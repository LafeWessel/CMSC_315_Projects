package Project_05;

import java.util.ArrayList;

public class Simulator {
	
	public double arrivalPreference; //This is the percent of the time that an arrival will be chosen over a departure
	
	private double currentTime;
	private int totalArr;
	private int totalDep;
	private int totalCrash;
	private double aveArrWait;
	private double aveDepWait;
	//Number of planes at end of simulation
	private int waitingDep;
	private int waitingArr;
	
	private ArrayList<Plane> airQ;
	private ArrayList<Plane> completed;
	
	
	public Simulator()
	{	
		currentTime = 0;
		arrivalPreference = 1.0;
		waitingDep = 0;
		waitingArr = 0;
		totalArr = 0;
		totalDep = 0;
		totalCrash = 0;

	}
	
	
	//Run simulation
	public void simulate(SimulationReader r, int runways) {
		
		//Create queue of planes
		airQ = new ArrayList<Plane>();
		completed = new ArrayList<Plane>();
		currentTime = 0.0;
		double[] runwayCDs = new double[runways];
		
		final double maxT = r.simTime();
		for(int i = 0; i < runwayCDs.length; i++) {
			runwayCDs[i] = 0;
		}
		
		while(currentTime < maxT) {
			
			checkCrashed(r.resFuelTime());

			//runway is open and a plane(s) are waiting
			for(int i = 0; i < runwayCDs.length; i++) {
				runwayCDs[i] = landOrDepartPlane(runwayCDs[i], r.landDur(), r.takeOffDur());
			}

			// Check to add planes to queue
			currentTime++;
			for(int i = 0; i < runwayCDs.length; i++) {
				runwayCDs[i]--;
			}
			this.addPlanesToQueue(r.arrRate(), r.depRate());

		}
		
		this.calcAveWait();
		this.calcTotWaiting();
		
	}


	public void checkCrashed(double reserveFuel) {
		//Check for crashed planes and remove any that have
		if(!airQ.isEmpty()) {
			for(int i = 0; i < airQ.size(); i++) {
				if(airQ.get(i).inFlight()) {
					if(currentTime - airQ.get(i).getIn() > reserveFuel) {
						totalCrash++;
						airQ.remove(airQ.get(i));
						//System.out.println("***Plane crashed at T+" + (int)currentTime + "***");
					}
				}
			}				
		}
	}
	
	//Lands or departs a plane and returns the new cooldown of the runway
	public double landOrDepartPlane(double runwayCD, double landDur, double takeOffDur) {
		if(1.0 > runwayCD && !airQ.isEmpty()) {
			//check to select an arrival for landing
			if(this.hasArrival(airQ) && Math.random() < arrivalPreference) {
				//select and remove first arrival
				int loc  = 0;
				while(!airQ.get(loc).inFlight()) {
					loc++;
				}
				airQ.get(loc).setOut(currentTime);
				completed.add(airQ.get(loc));
				airQ.remove(loc);
				totalArr++;
				runwayCD += landDur;
				//System.out.println("Landed a plane at T+" + (int)currentTime);
			}
			
			//send departure
			else {
				//select and remove first departure
				int loc  = 0;
				while(airQ.get(loc).inFlight()) {
					loc++;
				}
				airQ.get(loc).setOut(currentTime);
				completed.add(airQ.get(loc));
				airQ.remove(loc);
				totalDep++;
				runwayCD += takeOffDur;
				//System.out.println("Plane took off at T+" + (int)currentTime);
			}
		}
		return runwayCD;
	}
	
	//checks to see if any new planes need to be added to the queue and adds them if necessary
	public void addPlanesToQueue(double arrRate, double depRate) {
		if (Math.random() < depRate) {
			airQ.add(new Plane(currentTime, false));
			//System.out.println("Added departure at T+" + (int)currentTime);
		}
		if (Math.random() < arrRate) {
			airQ.add(new Plane(currentTime, true));
			//System.out.println("Added arrival at T+" + (int)currentTime);
		}

	}
	
	public int getTotArr()
	{	
		return totalArr;
	}
	public int getTotDep() {
		return totalDep;
	}
	public int getTotCrash() {
		return totalCrash;
	}
	
	//returns true if there are any planes still flying in the array
	public boolean hasArrival(ArrayList<Plane> plns) {
		for(Plane p : plns) {
			if(p.inFlight()) {
				return true;
			}
		}
		return false;
	}
	
	public double getAveArrWait() {
		return aveArrWait;
	}
	public double getAveDepWait() {
		return aveDepWait;
	}
	
	public String results() {
		return "Total Landed: " + totalArr + 
				"\nTotal Departed: " + totalDep + 
				"\nAve Land Wait: " + aveArrWait + 
				"\nAve Departure Wait: " + aveDepWait +
				"\nTotal Crashed: " + totalCrash +
				"\nTotal awaiting Departure: " + waitingDep +
				"\nTotal awaiting Landing: " + waitingArr + '\n';
	}
	
	public void calcAveWait() {
		//average wait for dep and arr
		int totArrT = 0;
		int totDepT = 0;
		for(Plane p : completed) {
			if(p.inFlight()) {
				totArrT += (p.getOut() - p.getIn());
			}
			else {
				totDepT += (p.getOut() - p.getIn());
			}
		}
		aveArrWait = (float)totArrT / (float)totalArr;
		aveDepWait = (float)totDepT / (float)totalDep;
	}
	
	public void calcTotWaiting()
	{	
		//Total awaiting landing/departure
		if(!airQ.isEmpty()) {
			for(Plane p : airQ) {
				if(p.inFlight()) {
					waitingArr++;
				}
				else {
					waitingDep++;
				}
			}
		}
	}
	
	
	
}