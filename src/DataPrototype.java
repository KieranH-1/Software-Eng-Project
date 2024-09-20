import java.io.*;


public class DataPrototype {
	public void dataProtoype(int userInput, String convertedUserInput, Source userSource, Storage storage, ReadWrite readWrite) {

		// read input from user specified source 
		ReadInputResponse readInput = readWrite.readFrom(userSource);
		
						
		//write converted input to user-specified source
		WriteOutputResponse writeOutput = readWrite.writeTo(convertedUserInput, userSource);
		
	}

}