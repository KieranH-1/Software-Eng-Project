import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.any;

public class ComputeEngineIntegrationTest {

	@Test
	public void testCompute() {
		Computer testComputer = new Computer();
		List<Integer> input = new ArrayList<>();
		
		input.add(1);
		input.add(10);
		input.add(25);
		
		if (testComputer.compute(input) != "1, one; 10, ten; 25, twenty-five") {
			fail();
		}
	}
}
