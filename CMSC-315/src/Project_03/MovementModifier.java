package Project_03;
//This class stores the movement modifiers for a certain move of the Knight

public class MovementModifier {
	public int x; //Row modifier
	public int y; //Column modifier
	
	MovementModifier(int row, int col){
		x = row;
		y = col;
	}
	
	public String toString() {
		return "x: " + x + " y: " + y;
	}
}
