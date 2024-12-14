package src;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import grpc.ComputeServiceGrpc.ComputeServiceImplBase;
import io.grpc.stub.StreamObserver;

public class ComputeServiceImpl extends ComputeServiceImplBase {
	private final DataStore ds;
	private final ComputeEngine ce;

	private static final int THREAD_POOL_SIZE = 4;
	private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

	public ComputeServiceImpl(DataStore ds, ComputeEngine ce) {
		if (ds == null) {
			throw new IllegalArgumentException("DataStore cannot be null.");
		}
		if (ce == null) {
			throw new IllegalArgumentException("ComputeEngine cannot be null.");
		}
		this.ds = ds;
		this.ce = ce;
	}

	public void compute(ComputeServiceOuterClass.ComputeRequest request,
			StreamObserver<ComputeServiceOuterClass.ComputeResult> resultObserver) {
			
		String inputFile = request.getInputFile();
		String outputFile = request.getOutputFile();
		String delim = request.getDelim();
		ComputeServiceOuterClass.ComputeResult result;
		
		//Validates that the ComputeRequest is not null
		if (request == null) {
			throw new IllegalArgumentException("ComputeRequest cannot be null.");
		}

		//Validates that the InputConfig within the request is not null.
		InputConfig inputConfig = new FileInputConfig(inputFile);
		if (inputConfig == null) {
			throw new IllegalArgumentException("InputConfig cannot be null.");
		}
		try {
			Iterable<Integer> integers = ds.read(inputConfig);

			FileOutputConfig outputConfig = new FileOutputConfig(outputFile);
			
			//Validates that the OutputConfig within the request is not null.
			if (outputConfig == null) {
				throw new IllegalArgumentException("OutputConfig cannot be null.");
			}
	
			List<Future<String>> futures = new ArrayList<>();
	
			for (Integer integer : integers) {
				//Validates that the input integers are not null
				if (integer == null) {
					throw new IllegalArgumentException("Input integers cannot be null.");
				}
				futures.add(executor.submit(() -> ce.compute(integer)));
			}
	
			for (Future<String> future : futures) {
				String result = future.get();
				if (result == null) {
					return ComputeResult.FAILURE;
				}
				WriteResult writeResult = ds.appendSingleResult(outputConfig, result);
				if (writeResult.getStatus() == WriteResult.WriteResultStatus.FAILURE) {
					return ComputeResult.FAILURE;
				}
			}
	
			return ComputeResult.SUCCESS;

		} catch (Exception e) {
			return ComputeResult.FAILURE;
		} finally {
			executor.shutdown();
		}
		
		
		
		
	}
	
}
