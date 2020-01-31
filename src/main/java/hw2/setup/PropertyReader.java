package hw2.setup;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static PropertyFile propertyFile = null;

    private static Properties properties = null;

    private PropertyReader() {
    }

    public static void setPropertyFile(final PropertyFile propFile) {
        if (propertyFile == null) {
            propertyFile = propFile;

            String PROPERTIES_PATH = System.getProperty("user.dir")
                    + "/src/test/resources/"
                    + propertyFile.getFilename();

            try {
                File propertiesFile = new File(PROPERTIES_PATH);
                properties = new Properties();
                properties.load(new FileReader(propertiesFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(final String key) {
        return properties.getProperty(key);
    }
}
