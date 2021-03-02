package Chapter6;

import java.util.ArrayList;
import java.util.Iterator;

public class Questions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*//6.6
		 * ArrayList<Double> myList = new ArrayList<Double>();
		 * 
		 * myList.add(5.1); myList.add(5.2); myList.add(5.3); myList.add(5.4);
		 * myList.add(5.5); myList.add(5.6); myList.add(5.7); myList.add(5.8);
		 * 
		 * 
		 * int i = 0; int j = 5;
		 * 
		 * myList.set(i, myList.set(j, myList.get(i)));
		 * System.out.println(myList.toString());
		 */	
		
		ArrayList<String> str = new ArrayList<String>();
		str.add("word");
		str.add("hello");
		str.add("thrice");
		str.add("indicative");
		str.add("And");
		str.add("be");
		
		for(int i = 0; i < str.size(); i++) {
			if(str.get(i).length() < 5) {
				System.out.println(str.get(i));
			}
		}
		
		System.out.println("\n\n\n");
		
		Iterator<String> it = str.iterator();
		
		while(it.hasNext()) {
			String s = it.next();
			if(s.length() < 5) {
				System.out.println(s);
			}
		}
		
		System.out.println("\n\n\n");
		
		
		for(String s : str) {
			if(s.length() < 5) {
				System.out.println(s);
			}
		}
		
	}
	
	//Output:
	//[5.6, 5.2, 5.3, 5.4, 5.5, 5.1, 5.7, 5.8]

}
