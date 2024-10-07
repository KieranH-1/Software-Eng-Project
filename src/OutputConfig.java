import java.util.List;
public interface OutputConfig {
  public List<String> getOutputMutable();
  public FileOutputConfig(String fileName);
  public String getFileName();
}
