package work.microhand.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author SanseYooyea
 */
public class Derby {
    private Connection connection;

    public Derby(Properties properties) {
        try {
            Class.forName(properties.getProperty("druid.driverClassName"));
            String url = properties.getProperty("druid.url");
            // jdbc:derby:crosswords;create=true
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);

            closeConn();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("§c| Derby 数据库打开失败！");
            return;
        }
        System.out.println("§a| Derby 数据库打开成功！");
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConn() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
