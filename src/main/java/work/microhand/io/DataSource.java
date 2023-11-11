package work.microhand.io;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author SanseYooyea
 */
public class DataSource {
    public static DataSource instance;
    private final DruidDataSource dataSource;

    /**
     * 从配置文件中读取数据源配置
     *
     * @param properties 配置文件
     */
    public DataSource(Properties properties) {
        dataSource = new DruidDataSource();
        dataSource.configFromPropety(properties);
        instance = this;
    }

    public static DataSource getInstance() {
        return instance;
    }

    public DruidDataSource getDataSource() {
        return dataSource;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void close() {
        dataSource.close();
    }
}