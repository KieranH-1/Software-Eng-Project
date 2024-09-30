import java.util.*;
public interface InputConfig {
  public List<Integer> inputData = new ArrayList<>();
  public InputConfig(List<Integer> inputData) {
        this.inputData = inputData;
    }

    public List<Integer> getInputData() {
        return inputData;
    }

}
