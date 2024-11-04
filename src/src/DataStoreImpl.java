package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Collections;
//import WriteResult.WriteResultStatus;
//import java.util.Iterator;


public class DataStoreImpl implements DataStore {

	@Override
	public Iterable<Integer> read(InputConfig input) {
		List<Integer> userIntegers = new ArrayList<>();
		if (input == null) {
			return null;
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader(input.getFileName()))) {
			String line;
			while ((line = br.readLine()) != null) {
				try {
					String[] userIntArray = line.split(",");
					
					for (String integer : userIntArray) {
						userIntegers.add(Integer.parseInt(integer));
					}
					
				} catch (NumberFormatException e) {
					System.err.println("Integer is invalid :( :" + line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return userIntegers;	
	}

	//@Override
	public WriteResult appendSingleResult(OutputConfig output, String result) {
		//return () -> WriteResult.WriteResultStatus.FAILURE;
		if (output == null) {
			return () -> WriteResult.WriteResultStatus.FAILURE;
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(output.getFileName(), true))) {
            	writer.write(result);
            	writer.newLine();
            	return () -> WriteResult.WriteResultStatus.SUCCESS;
        } catch (NullPointerException e) {
            	return () -> WriteResult.WriteResultStatus.FAILURE;
        } catch (IOException e) {
        	return () -> WriteResult.WriteResultStatus.FAILURE;
    }
	}

}
