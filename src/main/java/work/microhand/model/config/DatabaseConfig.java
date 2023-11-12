package work.microhand.model.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {

    private static final Properties PROPERTIES = new Properties();

    public static Properties getProperties() {
        return PROPERTIES;
    }

    public static void init() {
        try (InputStream is = DatabaseConfig.class.getResourceAsStream("/database.properties")) {
            PROPERTIES.load(is);
        } catch (IOException e) {
            System.out.println("Failed to load config file: " + e.getMessage());
        }
    }
}
