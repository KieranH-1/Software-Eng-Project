package src;

import java.util.List;

public class FileOutputConfig implements OutputConfig {

    private final String fileName;

    public FileOutputConfig(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public List<String> getOutputMutable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOutputMutable'");
    }

}
