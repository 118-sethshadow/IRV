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


public class Irv{
	  
	// opens the input file
	public static FileInputStream ballot(String fName) throws FileNotFoundException {
	  return new FileInputStream(fName);
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
	
	FileInputStream InStr = null;
	PrintStream PStr = null;
	
	try {
        InStr = ballot(args[0]);
        PStr = write(args[1]);
    } catch(FileNotFoundException e) {
        System.out.println("Error with input or output file");
        System.exit(0);
    }
	
Irv elections = new Irv();
elections.readFile(InStr, PStr, args[0], args[1]);
	
	
}//end main

void readFile(FileInputStream ballot, PrintStream write, String inputFile, String outputFile){
	
	

	
	try{
		 ballot = new FileInputStream(inputFile);
		BufferedReader read = new BufferedReader(new InputStreamReader(ballot));

    	 String strLine = "";
    	 String name = "";
    	 String[] tokens = strLine.split("  ");
    
    	 
        //the writer and file to write to
        File result = new File(outputFile);
        write = new PrintStream(result);
        
        
    	write.println("Election input file : " + inputFile);

    	//read the file line by line
    	while((strLine = read.readLine()) != null){
    		//check for candidates                   this will prevent reading empty String ("")
    		if(strLine.startsWith("<b>")==false && strLine.length()>1){
    		tokens = strLine.split("  ");
    			candidates.add(new String(tokens[0]));
    		}
    		else if(strLine.startsWith("<b>")){
    		//check for ballots
    			tokens = strLine.split(" ");
        		ballotNum.add(new String(tokens[0]));
    		}
  
    	}
    	
    	
    	//data to write to the results file
    	write.println("Number of candidates: " + candidates.size());
		write.println("The candidates:  ");
		for(int i = 0; i < candidates.size(); i ++){
		write.println("    " + candidates.get(i));
		}
		write.println("total ballots: " + ballotNum.size());
		write.println("Legal ballots: ");
		write.println("discarded ballots: ");

		
    	System.out.println(candidates);
    	System.out.println(ballotNum);
    	
    	//close reader and writer
    	read.close();
    	write.close();
    		
    }//end try
	
	catch (Exception e){
		// Catch exception if any and display the stack trace 
		System.err.println("Error: " + e.getMessage());
		e.printStackTrace();
	}
	
	System.out.print("Written " + outputFile + " based on " + inputFile);
}//end readFile




}//end Irv class





