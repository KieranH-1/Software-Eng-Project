import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

public class ComputationCoordinatorTest {

   @Test
    public void testCompute() {
        InputConfig mockInputConfig = Mockito.mock(InputConfig.class);
        OutputConfig mockOutputConfig = Mockito.mock(OutputConfig.class);
        ComputationCoordinator mockCC = Mockito.mock(ComputationCoordinator.class);
        ComputeRequest request = new ComputeRequest(mockInputConfig, mockOutputConfig);

        ComputeResult result = mockCC.compute(request);
        if (!result.equals("one")) {
            fail();
        }
    }
}
