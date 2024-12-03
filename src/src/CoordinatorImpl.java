<<<<<<< Updated upstream
package src;

public class CoordinatorImpl implements ComputationCoordinator {
	
	private final DataStore ds;
	private final ComputeEngine ce;
	
	public CoordinatorImpl(DataStore ds, ComputeEngine ce) {
		if (ds == null) {
			throw new IllegalArgumentException("DataStore cannot be null.");
		}
		if (ce == null) {
			throw new IllegalArgumentException("ComputeEngine cannot be null.");
		}
		this.ds = ds;
		this.ce = ce;
	}

	@Override
	public ComputeResult compute(ComputeRequest request) {
			
			try {
			//Validates that the ComputeRequest is not null
			if (request == null) {
				throw new IllegalArgumentException("ComputeRequest cannot be null.");
			}

			//Validates that the InputConfig within the request is not null.
			InputConfig inputConfig = request.getInputConfig();
			if (inputConfig == null) {
				throw new IllegalArgumentException("InputConfig cannot be null.");
			}
			Iterable<Integer> integers = ds.read(inputConfig);

			if (integers == null) {
				return ComputeResult.FAILURE;
			}

			OutputConfig outputConfig = request.getOutputConfig();
			//Validates that the OutputConfig within the request is not null.
			if (outputConfig == null) {
				throw new IllegalArgumentException("OutputConfig cannot be null.");
			}
			for (Integer integer : integers) {
				//Validates that the input integers are not null
				if (integer == null) {
					throw new IllegalArgumentException("Input integers cannot be null.");
				}

				String result = ce.compute(integer);

				if (result == null) {
					return ComputeResult.FAILURE;
				}

				WriteResult writeResult = ds.appendSingleResult(outputConfig, result);
				if (writeResult.getStatus() == WriteResult.WriteResultStatus.FAILURE) {
					return ComputeResult.FAILURE;
				}
			}

			return ComputeResult.SUCCESS;

		} catch (RuntimeException r) {
			
			return ComputeResult.FAILURE;
		} catch (Exception e) {
		
			throw new IllegalStateException("An unexpected error occurred: " + e, e );
		}
	}
}



=======
package src;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CoordinatorImpl implements ComputationCoordinator {

	private final DataStore ds;
	private final ComputeEngine ce;

	private static final int THREAD_POOL_SIZE = 4;
	private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

	public CoordinatorImpl(DataStore ds, ComputeEngine ce) {
		if (ds == null) {
			throw new IllegalArgumentException("DataStore cannot be null.");
		}
		if (ce == null) {
			throw new IllegalArgumentException("ComputeEngine cannot be null.");
		}
		this.ds = ds;
		this.ce = ce;
	}

	@Override
	public ComputeResult compute(ComputeRequest request) {
			//Validates that the ComputeRequest is not null
			if (request == null) {
				throw new IllegalArgumentException("ComputeRequest cannot be null.");
			}

			//Validates that the InputConfig within the request is not null.
			InputConfig inputConfig = request.getInputConfig();
			if (inputConfig == null) {
				throw new IllegalArgumentException("InputConfig cannot be null.");
			}
			try {
				Iterable<Integer> integers = ds.read(inputConfig);
			
			

			if (integers == null) {
				return ComputeResult.FAILURE;
			}

			OutputConfig outputConfig = request.getOutputConfig();
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



>>>>>>> Stashed changes
