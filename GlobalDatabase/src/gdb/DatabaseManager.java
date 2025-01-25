package gdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://"+ GlobalDatabase.databaseConfiguration.getHost() +
            ":" + GlobalDatabase.databaseConfiguration.getPort() +
            "/" + GlobalDatabase.databaseConfiguration.getDatabase();//localhost:3306/runescape_server";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, GlobalDatabase.databaseConfiguration.getUsername(), GlobalDatabase.databaseConfiguration.getPassword());
        }
        return connection;
    }

}
