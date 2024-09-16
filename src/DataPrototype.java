import java.io.*;


public class DataPrototype {
	public void dataProtoype(int userInput, String convertedUserInput, Source userSource, Storage storage) {

		// User input will be pos int
		// Initialize everything? 
		//InputResponse 
		
		// Create reader instance to properly process info
		
		// read input from user specified source 
		//ReadInputResponse readInput = userInput.readFrom(userSource);
		ReadInputResponse readInput = userSource.readFrom();
		
		//read output from storage
		ReadOutputResponse readOutput = storage.readFrom();
				
		// Create writer instance 
		
		//write to user-specified source
		WriteInputResponse writeInput = writeTo(userInput, userSource);
						
		//write to user-specified source
		WriteOutputResponse writeOutput = writeTo(convertedUserInput, userSource);
		
	}

}