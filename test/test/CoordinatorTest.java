package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import src.ComputationCoordinator;
import src.ComputeEngine;
import src.ComputeRequest;
import src.ComputeResult;
import src.CoordinatorImpl;
import src.DataStore;
import src.InputConfig;
import src.OutputConfig;

public class CoordinatorTest {

	@Test
	public void smokeTest() {
		// mock out the dependencies so that we're just checking the ComputationCoordinator
		DataStore dataStore = Mockito.mock(DataStore.class);
		ComputeEngine computeEngine = Mockito.mock(ComputeEngine.class);
		InMemoryInputConfig inputConfig = new InMemoryInputConfig();
		InMemoryOutputConfig outputConfig = new InMemoryOutputConfig();	
		ComputationCoordinator coord = new CoordinatorImpl(dataStore, computeEngine);
		
		// mock out the parameters
		ComputeRequest mockRequest = Mockito.mock(ComputeRequest.class);
		Mockito.when(mockRequest.getInputConfig()).thenReturn(new InMemoryInputConfig());
		Mockito.when(mockRequest.getOutputConfig()).thenReturn(new InMemoryOutputConfig());
		ComputeResult result = coord.compute(mockRequest);
		
		// simple check for right now - just say the result must be successful
		Assertions.assertEquals(result.getStatus(), ComputeResult.ComputeResultStatus.SUCCESS);
	}

	@Test
	public void testDataStoreReadExceptionHandled() {
		DataStore dataStore = Mockito.mock(DataStore.class);
		ComputeEngine computeEngine = Mockito.mock(ComputeEngine.class);

		ComputationCoordinator coord = new CoordinatorImpl(dataStore, computeEngine);

		ComputeRequest mockRequest = Mockito.mock(ComputeRequest.class);
		InputConfig mockInputConfig = Mockito.mock(InputConfig.class);
		Mockito.when(mockRequest.getInputConfig()).thenReturn(mockInputConfig);

		Mockito.when(dataStore.read(mockInputConfig)).thenThrow(new RuntimeException("DataStore read exception simulated."));

		ComputeResult result = coord.compute(mockRequest);

		Assertions.assertEquals(ComputeResult.ComputeResultStatus.FAILURE, result.getStatus());
	}
}
