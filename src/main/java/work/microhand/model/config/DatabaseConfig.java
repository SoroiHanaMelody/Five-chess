package work.microhand.model.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * @author SanseYooyea
 */
public class DatabaseConfig {

    private static Properties properties;

    public static Properties getProperties() {
        return properties;
    }

    public static void init() {
        URL configUrl = DatabaseConfig.class.getResource("/database.properties");
        File configFile = new File(configUrl.getFile());
        properties = new Properties();
        try (InputStream is = new FileInputStream(configFile)) {
            properties.load(is);
        } catch (IOException e) {
            System.out.println("Failed to load config file: " + e.getMessage());
        }
    }
}
