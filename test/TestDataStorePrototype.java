import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class TestDataStorePrototype {
	@Test
	public void testDataStoreRead(){
// in progress working thru issues 
		InputConfig mockInput = Mockito.mock(InputConfig.class);
		
		DataStore mockDataStore = new DataStoreImpl();
		Assertions.assertEquals(1L, dataStore.read(mockInput));
		//WriteResult mockWriteResult = Mockito.mock(WriteResult.class);

		//Iterable<Integer> loadData = mockDataStore.read(mockInput);
		
	}

	@Test
	public void testDataStoreWrite(){
		OutputConfig mockOutput = Mockito.mock(OutputConfig.class);
		DataStore mockDataStore = new DataStoreImpl();
		Assertions.assertEquals(WriteResultStatus.SUCCESS, dataStore.appendSingleResult(outputConfig, "result").getStatus());
	}
}
