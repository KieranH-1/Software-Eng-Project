
import java.util.List;

public class InMemoryInputConfig implements InputConfig {

    private final List<Integer> inputData;


    public InMemoryInputConfig(List<Integer> input) {
        this.inputData = input;
    }
    
    @Override
    public List<Integer> getInputData(){
        return inputData;
    }
}
