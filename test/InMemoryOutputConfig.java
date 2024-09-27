import java.util.ArrayList;

public class InMemoryOutputConfig implements OutputConfig{

    private final ArrayList<String> outputData;

    public InMemoryOutputConfig() {
        this.outputData = new ArrayList<>();
    }

    public ArrayList<String> getOutputData() {
        return outputData;
    }

    public void addOutputData(String data) {
        outputData.add(data);
    }
}
