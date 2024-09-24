import java.util.ArrayList;

public class InMemoryInputConfig implements InputConfig {

    private final ArrayList<Integer> inputData;


    public InMemoryInputConfig(ArrayList<Integer> inputData) {
        this.inputData = inputData;
    }

    public ArrayList<Integer> getInputData(){
        return inputData;
    }
}
