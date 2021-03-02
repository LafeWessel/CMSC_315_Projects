package Project_09_Addtl_Files;
import java.util.*;
import java.util.Scanner;

import java.io.*;

public class NetworkMain
{
	public static final String fileLoc = "C:\\Users\\wesse\\OneDrive\\Dordt\\2020 Fall\\CMSC 315\\Graphs\\";
	
    public static void loadNetwork(Network<String> n, String filename) {
        Scanner in = null;
        try {
            in = new Scanner(new File(filename));
        } catch (java.io.FileNotFoundException e) {
            System.out.println("could not open file " + filename);
            System.exit(1);
        }
        
        int i = 0;
        while(in.hasNextLine()) {
            i++;
            String line = in.nextLine().trim();
            System.out.println("Read in: " + line);
            if (line.equals("***")) {
                System.out.println("Read in " + i + " verticies.");
                break;
            }
            n.addVertex(line);
        }
    
        i = 0;
        while(in.hasNextLine()) {
            i++;
            String line = in.nextLine().trim();
            String[] inputs = line.split(",");
            if (inputs.length < 3) {
                System.out.println("Not enough inputs in edge line: " + line);
                System.exit(1);
            }
            System.out.println("Inserting new edge from " + inputs[0] +
                    " to " + inputs[1] + " with weight " + inputs[2]);
            n.addEdge(inputs[0].trim(), inputs[1].trim(), new Double(inputs[2]));
        }
        System.out.println("Read in " + i + " edges.");
    }
    
    public static void main (String[] args)  
    {
        
        //DirectedMatrixNetwork<String> network = new DirectedMatrixNetwork<String>();
    	DirectedMapNetwork<String> network = new DirectedMapNetwork<String>();
        loadNetwork(network, fileLoc + "dordtmap.dat");
        
        System.out.println ("\nnetwork = " + network.toString());
        LinkedList<Object> pathList = network.getShortestPath ("East Hall", "Classroom Building");
        System.out.println ("Shortest Path from East Hall to Classroom Building is " + pathList);
        System.out.println ("neighbors of BJ Haan Auditorium = " + network.neighbors("BJ Haan Auditorium"));

        boolean networkIsConnected = network.isConnected();
        System.out.println ("is connected is " + networkIsConnected);
        
        if (networkIsConnected)
            System.out.println ("spanning tree = " + network.getMinimumSpanningTree());
       
        System.out.println ("empty is " + network.isEmpty());
        System.out.println ("vertex count = " + network.size());
        System.out.println ("edge count = " + network.getEdgeCount());
        System.out.println ("contains(Covenant) is " + network.containsVertex("Covenant"));
        System.out.println ("contains edge (Covenant -- Campus Center) is " + network.containsEdge ("Covenant", "Campus Center"));
        System.out.println("contains edge (Covenent -- Southview) is " + network.containsEdge ("Covenant", "Southview"));
       
        System.out.println ("\n\nbreadth-first iterating from North Hall");
        Iterator<String> itr = network.breadthFirstIterator ("North Hall");
        while (itr.hasNext())
            System.out.print (itr.next() + " ");

        System.out.println ("\n\ndepth-first iterating from North Hall");
        itr = network.depthFirstIterator ("North Hall");
        while (itr.hasNext())
            System.out.print (itr.next() + " ");

        System.out.println ("\n\niterating over network:");
        for (String s : network)      
            System.out.print (s + " ");

        System.out.println ("\n\nedge weight of East Hall -- Gym is " + 
                    network.getEdgeWeight ("East Hall", "Gym"));
    } // method main

} // class NetworkMain
