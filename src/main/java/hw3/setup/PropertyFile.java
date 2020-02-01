package hw3.setup;

public enum PropertyFile {

    NATIVE("nativetest.properties"),
    WEB("webtest.properties");

    String filename;

    PropertyFile(final String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
