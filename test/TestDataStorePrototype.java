import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class TestDataStorePrototype {
	@Test
	public void testDataStore(){
// in progress working thru issues 
		InputConfig mockInput = Mockito.mock(InputConfig.class);
		OutputConfig mockOutput = Mockito.mock(OutputConfig.class);
		DataStore mockDataStore = Mockito.mock(DataStore.class);
		WriteResult mockWriteResult = Mockito.mock(WriteResult.class);

		Iterable<Integer> loadData = mockDataStore.read(mockInput);
		//WriteResult mockAppend = new appendSingleResult(mockOutput, result);

		
		if (loadData == null) {
            		fail();
		}
		
		String result = "result";
        	when(mockDataStore.appendSingleResult(mockOutput, result)).thenReturn(mockWriteResult);

		WriteResult mockAppend = mockDataStore.appendSingleResult(mockOutput, result);
        
       		if (mockAppend == null) {
            		fail("mockAppend should not be null");
        	}
		
		
	}
}
