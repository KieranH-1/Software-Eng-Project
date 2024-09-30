import java.util.ArrayList;
import java.util.List;

public class CoordinatorImpl implements ComputationCoordinator {
	
	private final DataStore ds;
	private final ComputeEngine ce;
	
	public CoordinatorImpl(DataStore ds, ComputeEngine ce) {
		this.ds = ds;
		this.ce = ce;
	}

	@Override
	public ComputeResult compute(ComputeRequest request) {
			InputConfig inputConfig = request.getInputConfig();
			Iterable<Integer> integers = ds.read(inputConfig);

			if (integers == null) {
				return ComputeResult.FAILURE;
			}

			OutputConfig outputConfig = request.getOutputConfig();
			for (Integer integer : integers) {
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
		}
	}



