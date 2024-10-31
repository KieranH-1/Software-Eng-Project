package test;

import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import src.DataStore;
import src.DataStoreImpl;
import src.InputConfig;
import src.OutputConfig;
import src.WriteResult;
/*
 * In this case, I've split out the smoke tests into two tests, one per method. It's also fine to consolidate
 * these into a single test
 */
public class DataStoreTest {

	@Test
	public void smokeTestRead() {
		// While there aren't any dependencies for this component, we can mock out the parameters
		InputConfig inputConfig = Mockito.mock(InputConfig.class);
		
		DataStore dataStore = new DataStoreImpl();
		Assertions.assertEquals(Collections.emptyList(), dataStore.read(inputConfig));
	}

	@Test
	public void smokeTestEmpty() {
		//make real
		OutputConfig outputConfig = Mockito.mock(OutputConfig.class);

		DataStore dataStore = new DataStoreImpl();
		
        WriteResult result = dataStore.appendSingleResult(outputConfig, "");
        
        Assertions.assertEquals(WriteResult.WriteResultStatus.FAILURE, result.getStatus());
        result = dataStore.appendSingleResult(outputConfig, null);
        Assertions.assertEquals(WriteResult.WriteResultStatus.FAILURE, result.getStatus());
	}
	
	@Test
	public void smokeTestWrite() {
		// While there aren't any dependencies for this component, we can mock out the parameters
		// This is optional; for simple parameters, if it's easier to use a real one (like String),
		// feel free to do that
		OutputConfig outputConfig = Mockito.mock(OutputConfig.class);
		
		DataStore dataStore = new DataStoreImpl();
		
		// assertEquals will use .equals, so this type of call is generally safe for any Object, but for enums you can also use ==
		// Note that if your dummy implementation returns null, this will NPE - that's fine! As long as the test fails,
		// the exact failure doesn't matter
		Assertions.assertEquals(WriteResult.WriteResultStatus.SUCCESS, dataStore.appendSingleResult(outputConfig, "result").getStatus());
	}
}
