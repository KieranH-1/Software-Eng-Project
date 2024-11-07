package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NetworkClient {
	
	 public static void main(String[] args) throws Exception {
		 List<Integer> userInput = new ArrayList<Integer>();
		 
		 //request input/output files & delimiter
		 try (Scanner sc = new Scanner(System.in)) {

			 System.out.println("Please include .txt on file names");
			 System.out.println("Please enter a txt file name: ");
			 String inputFileName = sc.nextLine();
			 File fileInput = new File(inputFileName);

			 System.out.println("Please enter a txt file for the output: ");
			 String outputFileName = sc.nextLine();
			 File fileOutput = new File(outputFileName);

			 char delimiter = ',';
			 System.out.println("Please enter a delimiter to use: ");
			 String charInput = sc.nextLine();
			 if (charInput.length() == 1) {
	                delimiter = charInput.charAt(0);
			 	}	 
		}
		 // Need to rework things so read can be used here
		 int num1 = 23;
		 ComputeRequest request = ComputeRequest.newBuilder()
	                .setInputNum(num1)
	                .build();
	    
		 // Need to rework so computation can be used
		 String word = "twenty-three";
	     ComputeResult result = ComputeResult.newBuilder()
	    		 .setResult(word)
	    		 .build();
	     
	     // confirm if task is successful
	     WriteResult taskSuccess = WriteResult.newBuilder()
                 .setTask(true)
                 .build();
		  
	 }
}
