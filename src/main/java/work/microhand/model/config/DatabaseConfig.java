package work.microhand.model.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {

    private static Properties properties;

    public static Properties getProperties() {
        return properties;
    }

    public static void init() {
        properties = new Properties();
        try (InputStream is = DatabaseConfig.class.getResourceAsStream("/database.properties")) {
            properties.load(is);
        } catch (IOException e) {
            System.out.println("Failed to load config file: " + e.getMessage());
        }
    }
}
