import java.io.*;
import java.nio.*;
import java.util.*;

import java.util.Collections;
//import WriteResult.WriteResultStatus;

public class DataStoreImpl implements DataStore {

	@Override
	public Iterable<Integer> read(InputConfig input) {
		return Collections.emptyList(); // eventually this will be a stream, but for now always return 0 elements
	}

	@Override
	public WriteResult appendSingleResult(OutputConfig output, String result) {
		if (output == null) {
			return () -> WriteResult.WriteResultStatus.FAILURE;
		}
		
		(output).getOutputMutable().add(result);
		FileWriter fw = new FileWriter("output.txt");
	    	BufferedWriter writer = new BufferedWriter(fw);
	   	writer.write(result);
	    
	   	writer.close();
		
		return () -> WriteResult.WriteResultStatus.SUCCESS;
	}
}
