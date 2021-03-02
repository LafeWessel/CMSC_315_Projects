package Project_01;

public class CalendarDateTime extends CalendarDate {

	private int hour;
	private int minute;
	private int second;
	
	public CalendarDateTime(int day, int month, int year, int hour, int minute, int second) {
		
		super(day, month, year);
		
		if(hour < 0 || hour > 23 || second < 0 || second > 59 || minute < 0 || minute > 59) {
			throw new IllegalDateException("Invalid Date!");
		}
		
		this.hour =hour;
		this.minute=minute;
		this.second=second;
	}
	
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getSecond() {
		return second;
	}
	
	/*
	 * Returns the difference between two dateTimes in the following format
	 * [0] : days
	 * [1] : hours
	 * [2] : minutes
	 * [3] : seconds
	 */
	public int[] difference(CalendarDateTime date) {
		
		int[] d = {0,0,0,0};
		//diff in days using super class method
		int diff = this.difference((CalendarDate)date);

		//hours
		diff *= 24;
		diff += hour;
		diff -= date.getHour();
		//minutes
		diff *= 60;
		diff += minute;
		diff += date.getMinute();
		//seconds
		diff *= 60;
		diff += second;
		diff -= date.getSecond();
		
		diff = Math.abs(diff);
		
		//seconds
		d[3] = diff % 60;
		diff /= 60;
		//minutes
		d[2] = diff % 60;
		diff /= 60;
		//hours
		d[1] = diff % 24;
		diff /= 24;
		//days
		d[0] = diff;

		return d;
	}
	
	public String toString() {
		return super.toString() + " " + hour + ":" + minute + ":" + second;
	}
	
	
}
