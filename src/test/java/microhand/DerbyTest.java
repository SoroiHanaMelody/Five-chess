package microhand;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import work.microhand.io.Derby;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author SanseYooyea
 */
public class DerbyTest {
    private static Derby derby;

    @BeforeAll
    public static void setUp() {
        Properties properties = new Properties();
        properties.setProperty("druid.driverClassName", "org.apache.derby.jdbc.EmbeddedDriver");
        properties.setProperty("druid.url", "jdbc:derby:memory:testDB;create=true");
        derby = new Derby(properties);
    }

    @AfterAll
    public static void tearDown() {
        derby.closeConn();
    }

    @Test
    public void testDerbyConnection() {
        assertNotNull(derby.getConnection());
    }
}
