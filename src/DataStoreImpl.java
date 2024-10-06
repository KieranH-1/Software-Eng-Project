import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

import java.util.Collections;
//import WriteResult.WriteResultStatus;

public class DataStoreImpl implements DataStore {

	@Override
	public Iterable<Integer> read(InputConfig input) {
		
	}

	@Override
	public WriteResult appendSingleResult(OutputConfig output, String result) {
		if (output == null) {
			return () -> WriteResult.WriteResultStatus.FAILURE;
		}
		
		FileWriter fw = new FileWriter("output.txt");
	    	BufferedWriter writer = new BufferedWriter(fw);
	   	writer.write(result);
	    
	   	writer.close();
		
		return () -> WriteResult.WriteResultStatus.SUCCESS;
	}
}
