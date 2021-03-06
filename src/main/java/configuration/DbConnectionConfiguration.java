package configuration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionConfiguration {

    private static Connection connection = null;

    static {
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=AutomationTest";
        String user = "sa";
        String password = "adminroot1234!@";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
