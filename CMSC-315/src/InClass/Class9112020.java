package InClass;

import java.util.HashSet;

public class Class9112020 {
	public static void main (String[] args) {
		//Sudoku Solver
		
		int[][] board = new int[9][9];
		for(int i= 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				board[i][j] = -1;
			}
		}
		
		board[1][1] = 1;
		board[2][2] = 6;
		board[5][6] = 7;
		
		printBoard(board);
		System.out.println("\n\n\n");
		System.out.println(solveBoard(board));
		printBoard(board);
		
	}
	
	
	public static boolean solveBoard(int[][] board) {
		if(isSolved(board)) {
			return true;
		}
		
		int row = 0;
		int col = 0;
		
		//ensure that current spot is an open/blank spot
		while (board[row][col] > 0) {
			col++;
			if(col >= 9) {
				col  =0;
				row++;
			}
			if(row >= 9) {
				return isSolved(board);
			}
		}
		
		
		
		
		//try each number in the current spot
		for(int i = 1; i <=9; i++) {
			board[row][col] = i;
			if(row >= 9 ) {
				System.out.println("We shouldn't have gotten here");
			}
			
			printBoard(board);
			System.out.println("____________");
			
			if(isLegal(board) && solveBoard(board)) {
				return true;
			}
		}
		
		board[row][col] = -1;
		return false;
	}
	
	public static boolean isSolved(int[][] board) {
		//ensure all spots filled
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(board[i][j] < 1) {
					return false;
				}
			}
		}
		
		//rows
		for(int i = 0; i < 9; i++) {
			if(!checkRow(board, i)) {
				return false;
			}
		}
		
		//columns
		for(int i = 0; i < 9; i++) {
			if(!checkCol(board, i)) {
				return false;
			}
		}
		
		//cells
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				
			}
		}
		
		
		return true;
	}
	
	
	
	public static boolean checkRow(int[][] board, int row) {
		for(int i = 1; i <=9; i++) {
			boolean numFound = false;
			for(int j = 0; j < 9; j++) {
				if(board[row][j] == i) {
					numFound = false;
					break;
				}
			}
			if(!numFound) return false;
			
		}
		return true;
	}
	
	public static boolean checkCol(int[][] board, int col) {
		for(int i = 1; i <=9; i++) {
			boolean numFound = false;
			for(int j = 0; j < 9; j++) {
				if(board[j][col] == i) {
					numFound = false;
					break;
				}
			}
			if(!numFound) return false;
			
		}
		return true;
	}
	
	public static void printBoard(int[][] board) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + "  ");
			}
			System.out.print('\n');
		}
	}
	
	public static boolean isLegal(int[][] board) {
		HashSet<Integer> h = new HashSet<Integer>();
		for(int r =0; r < 9; r++) {
			h.clear();
			for(int c = 0; c < 9; c++) {
				if(h.contains(board[r][c])
						&& (board[r][c] > 0)) {
					return false;
				}
				else {
					h.add(board[r][c]);
				}
			}
		}
		
		for(int c =0; c < 9; c++) {
			h.clear();
			for(int r = 0; r < 9; r++) {
				if(h.contains(board[r][c])
						&& (board[r][c] > 0)) {
					return false;
				}
				else {
					h.add(board[r][c]);
				}
			}
		}
		return true;
	}
}
