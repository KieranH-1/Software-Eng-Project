public class FileInputConfig implements InputConfig {
    private String fileName;

    public FileInputConfig(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
