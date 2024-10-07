public class FileOutputConfig implements OutputConfig {
    private String fileName;

    public FileOutputConfig(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
