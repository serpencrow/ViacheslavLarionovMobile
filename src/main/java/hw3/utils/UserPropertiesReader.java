package hw3.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class UserPropertiesReader {

    public static User getUser(final String userPropertiesPath) {
        User user = null;

        try {
            File propertiesFile = new File(System.getProperty("user.dir")
                    + "/"
                    + userPropertiesPath);
            Properties properties = new Properties();
            properties.load(new FileReader(propertiesFile));

            user = new User(
                    properties.getProperty("email"),
                    properties.getProperty("username"),
                    properties.getProperty("password")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }
}
