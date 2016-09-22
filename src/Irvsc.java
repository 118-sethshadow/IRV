/*
 * Programmer: Kartikeya Kaushal
 * Class: CS 201
 * Lecturer: John Lillis
 * Project 1: Irv election
 */

import java.net.*;
import java.util.*;
import java.io.*;
import java.util.ArrayList;


public class Irvsc{
	  
	// opens the input file
	public static Scanner ballot(String fName) throws FileNotFoundException {
	  return new Scanner (new FileInputStream(fName));
	}

	// writes to output file
	public static PrintStream write(String fName) throws FileNotFoundException {
	  return new PrintStream(new FileOutputStream(fName));
	}
	  

	

	
	//arraylists to store data
	ArrayList<String> candidates = new ArrayList<String>();
	ArrayList ballotNum = new ArrayList();

public static void main(String[] args){
	
	if(args.length != 2) {
        System.out.println("Must specify input file and output file on cmd line");
        System.exit(0);
    }
	
	Scanner InStr = null;
	PrintStream PStr = null;
	
	try {
        InStr = ballot(args[0]);
        PStr = write(args[1]);
    } catch(FileNotFoundException e) {
        System.out.println("Error with input or output file");
        System.exit(0);
    }
	
Irvsc elections = new Irvsc();
elections.readFile(InStr, PStr, args[0], args[1]);
	
	
}//end main

void readFile(Scanner ballots, PrintStream write, String inputFile, String outputFile){
	
	

	
	try{
		 ballots = new Scanner (new FileInputStream(inputFile));
		 ballots.useDelimiter("\n");
		 String line = "";
    	 
        //the writer and file to write to
        File result = new File(outputFile);
        write = new PrintStream(result);
        
        
        write.println("Name of file with candidates and ballots: " + inputFile);
        
    	//read the file line by line
        if(ballots.hasNext("<b>")==false){
        	while((ballots.hasNext())){
    		
        		//check for candidates
    			candidates.add(ballots.next());
        	}
        }
    		//check for ballots
    	else if(ballots.hasNext("<b>")){
    		while((ballots.hasNext())){
    			ballotNum.add(ballots.next());
    		}

    		}
  
    		
    	
    	
    	write.println("Number of candidates: " + candidates.size());
		write.println("The candidates:  \n");
		for(int i = 0; i < candidates.size(); i++){
		write.println(candidates.get(i));
		}
		write.println("total ballots: " + ballotNum.size());
		write.println("Legal ballots: ");
		write.println("discarded ballots: ");
    	
    	//close reader and writer
    	ballots.close();
    	write.close();
    		
    }
	catch (Exception e){
		// Catch exception if any and display the stack trace 
		System.err.println("Error: " + e.getMessage());
		e.printStackTrace();
	}
	

}




}//end Irvsc class





