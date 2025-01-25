package gdb;

import java.sql.SQLException;

public class Main {

    public static DatabaseConfiguration databaseConfiguration;

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        databaseConfiguration = new DatabaseConfiguration();
        try {
            if(DatabaseManager.getConnection() != null)
                System.out.println("Success!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}