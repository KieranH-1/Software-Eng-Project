public class FileInputConfig implements InputConfig {
    private String fileName;

    public FileInputConfig(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
