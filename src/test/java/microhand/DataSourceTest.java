package microhand;

import org.junit.jupiter.api.Test;
import work.microhand.io.DataSource;

import java.sql.SQLException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author SanseYooyea
 */
public class DataSourceTest {

    @Test
    public void testInitDatabase() {
        // 创建一个模拟的Properties对象
        Properties properties = new Properties();
        properties.setProperty("druid.driverClassName", "org.apache.derby.jdbc.EmbeddedDriver");
        properties.setProperty("druid.url", "jdbc:derby:memory:testdb;create=true");

        DataSource dataSource = new DataSource(properties);

        // 验证数据库是否成功创建
        assertTrue(dataSource.getDataSource().isEnable());
    }

    @Test
    public void testGetDataSource() {
        // 创建一个模拟的Properties对象
        Properties properties = new Properties();
        properties.setProperty("druid.driverClassName", "org.apache.derby.jdbc.EmbeddedDriver");
        properties.setProperty("druid.url", "jdbc:derby:memory:testdb;create=true");

        DataSource dataSource = new DataSource(properties);

        // 验证返回的数据源对象不为空
        assertNotNull(dataSource.getDataSource());
    }

    @Test
    public void testGetConnection() throws SQLException {
        // 创建一个模拟的Properties对象
        Properties properties = new Properties();
        properties.setProperty("druid.driverClassName", "org.apache.derby.jdbc.EmbeddedDriver");
        properties.setProperty("druid.url", "jdbc:derby:memory:testdb;create=true");

        DataSource dataSource = new DataSource(properties);

        // 验证从数据源获取的连接不为空
        assertNotNull(dataSource.getConnection());
    }
}
