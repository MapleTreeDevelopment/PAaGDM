package gdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Diese Klasse verwaltet die Verbindung zur Datenbank.
 * Sie stellt sicher, dass nur eine Verbindung erstellt wird (Singleton-Muster),
 * und nutzt die globale Datenbankkonfiguration aus `GlobalDatabase`.
 */
public class DatabaseManager {

    // URL für die Verbindung zur Datenbank
    private static final String URL = "jdbc:mysql://" + GlobalDatabase.databaseConfiguration.getHost() +
            ":" + GlobalDatabase.databaseConfiguration.getPort() +
            "/" + GlobalDatabase.databaseConfiguration.getDatabase();

    // Singleton-Instanz der Datenbankverbindung
    private static Connection connection;

    /**
     * Liefert eine Verbindung zur Datenbank.
     * Falls die Verbindung noch nicht besteht oder geschlossen ist, wird eine neue Verbindung aufgebaut.
     *
     * @return Eine gültige `Connection` zur Datenbank.
     * @throws SQLException Falls beim Aufbau der Verbindung ein Fehler auftritt.
     */
    public static Connection getConnection() throws SQLException {
        // Prüfe, ob die Verbindung existiert und offen ist
        if (connection == null || connection.isClosed()) {
            // Stelle eine Verbindung zur Datenbank her
            connection = DriverManager.getConnection(
                    URL,
                    GlobalDatabase.databaseConfiguration.getUsername(),
                    GlobalDatabase.databaseConfiguration.getPassword()
            );
        }
        return connection;
    }
}
