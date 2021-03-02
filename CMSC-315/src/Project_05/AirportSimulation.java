package Project_05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//This class runs the airport simulation

public class AirportSimulation {

	public static final String DIRECTORY = "C:\\Users\\Lafe Wessel - Laptop\\OneDrive\\Dordt\\2020 Fall\\CMSC 315\\JavaPrograms\\CMSC-315\\src\\Project_05\\dataFiles";
	
	
	
	
	
	public static void main(String[] args) {
		
		// read in files from DIRECTORY
		File txtFiles = new File(DIRECTORY);
		SimulationReader reader = new SimulationReader();
		
		// read words from each file
		for(File f : txtFiles.listFiles()) {
			System.out.println("----------------------------------------------------------------------");
			System.out.println("Reading from: " + f.getName());
			try {
				Scanner s = new Scanner(f);	
				reader.readWords(s);
				s.close();
				
				System.out.println(reader.toString());
				
				//run simulation with 1 runway
				System.out.println("\nTesting with 1 runway");
				Simulator sim = new Simulator();
				sim.arrivalPreference = 1.0; // sets arrival preference over departure
				sim.simulate(reader,1);				
				System.out.println(sim.results());
				
				//run simulation with 2 runways
				sim = new Simulator();
				System.out.println("\nTesting with 2 runways");
				sim.arrivalPreference = 1.0; // sets arrival preference over departure
				sim.simulate(reader,2);				
				System.out.println(sim.results());
				
			}
			catch(FileNotFoundException e) {
				System.out.println("Cannot find file named: " + f.getName());
			}
			
			
		}
	}
	
	

}
