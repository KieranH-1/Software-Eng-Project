package test;

import java.io.File;

import src.ComputationCoordinator;
import src.ComputeRequest;
import src.InputConfig;
import src.OutputConfig;



public class TestUser {
	
	// TODO 3: change the type of this variable to the name you're using for your
	// User <-> ComputeEngine API; also update the parameter passed to the constructor
	private final ComputationCoordinator coordinator;

	public TestUser(ComputationCoordinator coordinator) {
		this.coordinator = coordinator;
	}

	public void run(String outputPath) {
		char delimiter = ';';
		String inputFile = "test" + File.separatorChar + "testInputFile.test";
		String outputFile = "test" + File.separatorChar + "testOutputFile.test";
		
		// TODO 4: Call the appropriate method(s) on the coordinator to get it to 
		// run the compute job specified by inputPath, outputPath, and delimiter
		InputConfig inputConfig = new InMemoryInputConfig(inputFile);
		OutputConfig outputConfig = new InMemoryOutputConfig(outputFile);
		
		ComputeRequest request = new ComputeRequest(inputConfig, outputConfig, delimiter);
		coordinator.compute(request);
	}

}
