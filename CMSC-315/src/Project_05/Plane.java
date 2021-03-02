package Project_05;

public class Plane {

	private double inQ; //time entered queue
	private double outQ; //time exited queue
	private boolean isFlying; //whether the plane was flying when it entered the queue (was an arrival)
	
	public Plane(double in, boolean isD) {
		isFlying = isD;
		inQ = in;
	}
	
	public void setOut(double out) {
		outQ = out;
	}
	
	public double getIn() {
		return inQ;
	}
	public double getOut() {
		return outQ;
	}
	public boolean inFlight() {
		return isFlying;
	}
	
}
