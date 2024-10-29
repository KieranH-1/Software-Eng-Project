public class FileOutputConfig implements OutputConfig {
    private String fileName;

    @Override
    public FileOutputConfig(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
