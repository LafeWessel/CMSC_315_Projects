package Project_04;

public class UIntEntry {
	public UIntEntry next;
	public UIntEntry prev;
	public int val;
	
	public UIntEntry() {
		next = null;
		prev= null;
		val = 0;
	}
	
	public UIntEntry(int v) {
		next = null;
		prev = null;
		val = 0;
		setVal(v);
	}
	
	public UIntEntry(int v, UIntEntry n, UIntEntry p) {
		next = n;
		prev = p;
		val = 0;
		setVal(v);
	}
	
	
	public void setVal(int v) {
		if(v > 9) {
			System.err.println("Can't make digit > 9!");
		}
		else {
			val = v;
		}
	}
	
	
}
