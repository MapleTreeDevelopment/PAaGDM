package gdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://"+ Main.databaseConfiguration.getHost() +
            ":" + Main.databaseConfiguration.getPort() +
            "/" + Main.databaseConfiguration.getDatabase();//localhost:3306/runescape_server";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, Main.databaseConfiguration.getUsername(), Main.databaseConfiguration.getPassword());
        }
        return connection;
    }

}
