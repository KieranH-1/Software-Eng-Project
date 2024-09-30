
public interface OutputConfig {
  public List<String> outputData;
  public InputConfig(List<String> outputData) {
        this.outputData = outputData;
    }

    public List<String> getOutputData() {
        return outputData;
    }
}
