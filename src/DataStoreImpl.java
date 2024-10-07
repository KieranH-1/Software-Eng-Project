
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
//import WriteResult.WriteResultStatus;

import edu.softwareeng.sample.InputConfig;

public class DataStoreImpl implements DataStore {

	@Override
	public Iterable<Integer> read(InputConfig input) {
		List<Integer> userIntegers = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(input.getFileName()))) {
			String line;
			while ((line = br.readLine()) != null) {
				try {
					userIntegers.add(Integer.parseInt(line.trim()));
				} catch (NumberFormatException e) {
					System.err.println("Skipping invalid integer: " + line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return userIntegers;
	}

	@Override
	public WriteResult appendSingleResult(OutputConfig output, String result) {
		
		 // Using lambda syntax to create an instance of WriteResult. This is an alternative to the ComputeResult approach of providing
		 // constants for success/failure.
		if (output == null) {
			return () -> WriteResult.WriteResultStatus.FAILURE;
		}
		 
		//((InMemoryOutputConfig) output).getOutputMutable().add(result);
		FileWriter fw = new FileWriter("output.txt");
	    	BufferedWriter writer = new BufferedWriter(fw);
	   	writer.write(result);
	    
	   	writer.close();
		
		return () -> WriteResult.WriteResultStatus.SUCCESS;
	}
}
