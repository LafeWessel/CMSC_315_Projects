package Project_09_Addtl_Files;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

public class SnakesLaddersApp {
	
	public static final int BOARD_SIZE = 100;
	public static final int DIE_SIDES = 6;
	
	public static HashMap<Integer,Integer> snakes;
	public static HashMap<Integer, Integer> ladders;
	
	
	
	public static void main(String[] args) {
		
		snakes = new HashMap<Integer,Integer>();
		ladders = new HashMap<Integer,Integer>();
		//	( to, from)
		snakes.put(6, 36);
		snakes.put(10, 32);
		snakes.put(18, 62);
		snakes.put(24, 88);
		snakes.put(26, 48);
		snakes.put(56,95);
		snakes.put(78, 97);
		
		ladders.put(38, 1);
		ladders.put(14, 4);
		ladders.put(30, 8);
		ladders.put(42, 21);
		ladders.put(76, 28);
		ladders.put(67, 50);
		ladders.put(92, 71);
		ladders.put(99, 80);
		
		
		// Initialize Board
		
		// Initialize basic 100 spots
		DirectedMapNetwork<Integer> map = new DirectedMapNetwork<Integer>();
		for (int i = 0; i <= BOARD_SIZE; i++) { // for each of the 100 spots on the board
			map.addVertex(i);			
			for( int r = 1; r <= DIE_SIDES; r++) { // for each of the possible moves from a spot
				int end = i + r;
				if(end > 100) {
					end = 100;
				}
				map.addEdge(i, end, 1);
			}
		}
		// Add snakes and ladders
		
		// Add snakes
		Iterator<Entry<Integer,Integer>> sn = snakes.entrySet().iterator();
		while(sn.hasNext()) {
			Entry<Integer,Integer> e = (Entry<Integer,Integer>)sn.next();
			Integer k = e.getKey();
			Integer v = e.getValue();
			// Iterate through graph to find, remove, and replace edges to k w/ edges to v
			for(int i = 0; i <= 100; i++) {
				
				if(map.removeEdge(i, v)) {
					map.addEdge(i, k, 1);
				}	
			}
		}
		
		//Add ladders
		Iterator<Entry<Integer,Integer>> ldr = ladders.entrySet().iterator();
		while(ldr.hasNext()) {
			Entry<Integer,Integer> e = (Entry<Integer,Integer>)ldr.next();
			Integer k = e.getKey();
			Integer v = e.getValue();
			// Iterate through graph to find, remove, and replace edges to k w/ edges to v
			for(int i = 0; i <= 100; i++) {
				
				if(map.removeEdge(i, v)) {
					map.addEdge(i, k, 1);
				}	
			}
		}
		
		//System.out.println(map.toString());
		
		LinkedList<Object> path = map.getShortestPath(0, 100);
		
		System.out.println("Path: " + path.toString());
		
		ArrayList<Integer> rolls = new ArrayList<Integer>();
		
		// Calculate the rolls that were made
		for(int i = 0; i < path.size()-2; i++) {
			int current = (Integer)path.get(i);
			int next = (Integer)path.get(i+1);
			int roll = 0;
			//Know it was a rolled number w/o snake or ladder
			if(next - current <= 6) {
				roll = next-current;
			}
			// must look in ladders
			else if(next > current){
				// find what has a connection to the next
				Integer m = ladders.get(next);
				roll = m - current;
			}
			// must look in snakes
			else if(next < current){
				Integer m = snakes.get(next);
				roll = m - current;
			}
			rolls.add(roll);
		}
		
		System.out.println("Rolls: " + rolls.toString());
	}
}
