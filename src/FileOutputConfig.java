public class FileOutputConfig implements OutputConfig {
    private String fileName;

    @Override
    public FileOutputConfig(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
