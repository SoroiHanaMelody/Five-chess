package work.microhand;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import work.microhand.model.config.DatabaseConfig;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConfigTest {
    @BeforeAll
    public static void setUp() {
        DatabaseConfig.init();
    }

    @Test
    public void testInit_Positive() {
        Properties properties = DatabaseConfig.getProperties();
        assertNotNull(properties);
        assertEquals("org.apache.derby.jdbc.EmbeddedDriver", properties.getProperty("druid.driverClassName"));
        assertEquals("jdbc:derby:crosswords;create=true", properties.getProperty("druid.url"));
    }

    @Test
    public void testInit_Negative() {
        Properties properties = DatabaseConfig.getProperties();
        assertNotNull(properties);
        assertNotEquals("value3", properties.getProperty("key1"));
    }
}
