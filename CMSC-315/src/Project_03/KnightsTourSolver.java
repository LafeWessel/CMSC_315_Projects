package Project_03;

/**
 *
 * @author nbreems
 */

public class KnightsTourSolver {

    /**
     *
     * @param board
     * @param x
     * @param y
     * @param num
     * @return
     */
	
	public static final MovementModifier[] MODS = {
			new MovementModifier(-2,1),
			new MovementModifier(-2,-1),
			new MovementModifier(2,1),
			new MovementModifier(2,-1),
			new MovementModifier(1,2),
			new MovementModifier(1,-2),
			new MovementModifier(-1,2),
			new MovementModifier(-1,-2)
	};
	
    static public boolean solveKnightsTour(KnightsTourBoard board, int x, int y, int num) {
    	
		//Return true when the number of filled spots is the same as the number of spots on the board
		if(num > board.getBoardSize() * board.getBoardSize()) {
			return true;
		}
		
        //board.printBoard();
        board.setProgressIndicator(num);
        
        boolean legalMove = false;
        boolean solutionFound = false;
        
    	//Attempt each movement
    	for(int i = 0; i < MODS.length; i++) {
    		legalMove = true;
    		//Ensure we don't move off the edge of the board
    		//Legal if not off board in x direction
    		if(x + MODS[i].x > board.getBoardSize() -1 ||		//Off board in x positive
    				x + MODS[i].x < 0 ||						//Off board in x negative
    				y + MODS[i].y > board.getBoardSize() -1 ||	//Off board in y positive
    				y + MODS[i].y < 0 ||						//Off board in y negative
    				!(board.getPositionValue(x + MODS[i].x, y + MODS[i].y) < 1)) { //Board spot not filled
    			legalMove = false;
    		}
    		
    		if(legalMove) {
    			board.setPositionValue(x + MODS[i].x, y + MODS[i].y, num);
    			if(solveKnightsTour(board, x + MODS[i].x, y + MODS[i].y, num+1)) {
    				return true;
    			}
    		}
    		
    		
    	}
    	

    	//Won't have found a legal move
		board.setPositionValue(x, y, -1);
		return false;  

      
        
        /* Your job is to complete this recursive function.  You are
	 * given a board, an (x,y) position on the board, and the num
	 * of your next "visit" on the tour.  (i.e., position (x,y) was
	 * visit number num-1.)  If you can successfully complete the
	 * tour starting from the current layout, return true.  If it
	 * isn't possible to complete the tour from this state, return
	 * false. */
    
    }
    
}    
