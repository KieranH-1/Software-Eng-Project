
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputeTest {

	@Test
	public void smokeTestCompute1() {
		// The computation component has very simple inputs/outputs and no dependencies, so we can
		// write a smoke test with no mocks at all
		
		ComputeEngine engine = new ComputeEngineImpl();
		Assertions.assertEquals("nine-hundred ninety nine", engine.compute(999));
	}
	
	@Test
	public void smokeTestCompute2() {
		// The computation component has very simple inputs/outputs and no dependencies, so we can
		// write a smoke test with no mocks at all
		
		ComputeEngine engine = new ComputeEngineImpl();
		Assertions.assertEquals("zero", engine.compute(0));
	}
}
