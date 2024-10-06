import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Collections;
//import WriteResult.WriteResultStatus;

public class DataStoreImpl implements DataStore {

	@Override
	public Iterable<Integer> read(InputConfig input) {
		List<Integer> userIntegers = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(input.getFileName() ) ) ) {
			String line;
			while ((line = br.readLine()) != null) {
				try {
					userIntegers.add(Integer.parseInt(line.trim()));
				} catch (NumberFormatException e) {
					System.err.println("Integer is invalid :( :" + line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return userIntegers;
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
