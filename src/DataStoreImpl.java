// just chilling for rn

import java.util.List;

public class DataStoreImpl implements DataStore{
	//InputConfig input = null;
	//OutputConfig output = null;
	//String result = " ";
	
	public List<Integer> read(InputConfig inputConfig) {
		return inputConfig.getInputData();
	}

	public WriteResult appendSingleResult(OutputConfig output, String result) {
		return null;
	}
}
