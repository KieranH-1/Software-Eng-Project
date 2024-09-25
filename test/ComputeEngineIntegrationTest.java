import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ComputeEngineIntegrationTest {

	@Test
	public void testCompute() {
		Computer testComputer = new Computer();
		DataStore dataStoreImpl = new DataStoreImpl();
		List<Integer> input = new ArrayList<>();
		
		input.add(1);
		input.add(10);
		input.add(25);
		InMemoryInputConfig inputConfig = new InMemoryInputConfig(input);
		
		testComputer.compute(dataStoreImpl.read(inputConfig));
		
		if (testComputer.compute(input) != "1, one; 10, ten; 25, twenty-five") {
			fail();
		}
	}
}
