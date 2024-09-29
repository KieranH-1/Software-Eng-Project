import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import WriteResult.WriteResultStatus;

public class TestDataStorePrototype {
	@Test
	public void testDataStoreRead(){
// in progress working thru issues 
		InputConfig mockInput = Mockito.mock(InputConfig.class);
		
		DataStore mockDataStore = new DataStoreImpl();
		Assertions.assertEquals(1L, mockDataStore.read(mockInput));
		//WriteResult mockWriteResult = Mockito.mock(WriteResult.class);

		//Iterable<Integer> loadData = mockDataStore.read(mockInput);
		
	}

	@Test
	public void testDataStoreWrite(){
		OutputConfig mockOutput = Mockito.mock(OutputConfig.class);
		DataStore mockDataStore = new DataStoreImpl();
		Assertions.assertEquals(WriteResultStatus.SUCCESS, mockDataStore.appendSingleResult(mockOutput, "result").getStatus());
	}
}
