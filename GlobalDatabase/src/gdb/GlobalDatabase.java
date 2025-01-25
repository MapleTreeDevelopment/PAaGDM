package gdb;

import java.sql.SQLException;

public class GlobalDatabase {

    public static DatabaseConfiguration databaseConfiguration;

    public static void main(String[] args) {
        databaseConfiguration = new DatabaseConfiguration();
        try {
            if(DatabaseManager.getConnection() != null)
                System.out.println("Database connection established!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void init() {
        databaseConfiguration = new DatabaseConfiguration();
        try {
            if(DatabaseManager.getConnection() != null)
                System.out.println("Database connection established!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}