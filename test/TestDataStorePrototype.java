import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class TestDataStorePrototype {
	public void testDataStore(){
// in progress working thru issues 
		InputConfig mockInput = Mockito.mock(InputConfig.class);
		OutputConfig mockOutput = Mockito.mock(OutputConfig.class);
		DataStore mockDataStore = Mockito.mock(DataStore.class);
		WriteResult mockWriteResult = Mockito.mock(WriteResult.class);

		Iterable<Integer> loadData = new mockDataStore.read(mockInput);
		WriteResult mockAppend = new appendSingleResult(mockOutput, result);

		@Test
		if (loadData == null) {
            		fail();
		}
		
	}
}
