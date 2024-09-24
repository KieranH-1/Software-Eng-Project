import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class TestDataStorePrototype {
	public void testDataStore(){
		// Mocking out all input/output, + DataStore in order to test

		// MOCK InputConfig inputConfig = new InputConfig()
		InputConfig mockInput = Mockito.mock(InputConfig.class);
		// MOCK OutputConfig outputConfig = null;
		OutputConfig mockOutput = Mockito.mock(OutputConfig.class);
		// MOCK DataStore
		DataStore mockDataStore = Mockito.mock(DataStore.class);
		// MOCK WriteResult
		WriteResult mockWriteResult = Mockito.mock(WriteResult.class);

		// MOCK Iterable<Integer> read(InputConfig input);
		Iterable<Integer> loadData = new read(mockInput);

		// MOCK WriteResult appendSingleResult(OutputConfig output, String result);
		WriteResult mockAppend = new appendSingleResult(mockOutput, result);
		
		//TEST read
		//@Test
		loadData = mockDataStore.read(mockInput);
		if (loadData != mockInput){
			fail();
		}
			
		//TEST append
		//@Test
		for (int i : loadData){
			String result = "" + i;
			WriteResult mockWriteResult = mockDataStore.appendSingleResult(mockOutput, result);
			if (writeResult.getStatus() != WriteResult.WriteResultStatus.SUCCESS){
				System.out.println("Oh no.");
			}
		}
	}
}
