package Project_01;

public class TestCode {

	
	public static void main(String[] args) {
		
		//Month Day, Year StartTime
		
		//Jan 21, 2019 3:33
		CalendarDateTime l1 = new CalendarDateTime(21,1,2019,3,33,0);
		//July 27, 2018 18:24
		CalendarDateTime l2 = new CalendarDateTime(27,7,2018,18,24,0);		
		//Jan 31, 2018 11:48
		CalendarDateTime l3 = new CalendarDateTime(31,1,2018,11,48,0);
		//Sep 28, 2015 1:07
		CalendarDateTime l4 = new CalendarDateTime(28,9,2015,1,7,0);
		//Apr 4, 2015 10:15
		CalendarDateTime l5 = new CalendarDateTime(4,4,2015,15,15,0);
		
		CalendarDateTime[] c = {l1,l2,l3,l4,l5};
		int totalDiff = 0;
		for(int i = 0; i < c.length-1; i++) {
			System.out.println(c[i].toString() + " - " + c[i+1].toString());
			
			int[] a = c[i].difference(c[i+1]);
			int diff = 0;
			diff += a[0] * 24 * 60 * 60;
			diff += a[1] * 60 * 60;
			diff += a[2] * 60;
			diff += a[3];
			System.out.println("Diff: " + diff + " seconds(" + totalDiff+")");
			totalDiff += diff;
		}
		totalDiff /= 5;
		
		System.out.println("\nAverage diff in seconds: " + totalDiff);
		
		System.out.println("Average time difference: ");
		int sec = totalDiff % 60;
		totalDiff /= 60;
		int min = totalDiff % 60;
		totalDiff /= 60;
		int hr = totalDiff % 24;
		totalDiff /= 24;
		int day = totalDiff;
		
		System.out.println("Days:\t\t"+day);
		System.out.println("Hours:\t\t"+hr);
		System.out.println("Minutes:\t"+min);
		System.out.println("Seconds:\t"+sec);
		
		
	}
	
	
	
}
