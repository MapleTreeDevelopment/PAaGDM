package gdb;

import java.sql.SQLException;

/**
 * Diese Klasse dient als globaler Zugriffspunkt für die Datenbankkonfiguration
 * und stellt sicher, dass die Verbindung zur Datenbank initialisiert wird.
 */
public class GlobalDatabase {

    // Globale Datenbankkonfiguration
    public static DatabaseConfiguration databaseConfiguration;

    /**
     * Initialisiert die globale Datenbankkonfiguration und überprüft die Verbindung zur Datenbank.
     * Lädt die Konfigurationsdaten aus der Datei und stellt sicher, dass die Datenbankverbindung erfolgreich ist.
     */
    public static void init() {
        // Lade die Datenbankkonfiguration
        databaseConfiguration = new DatabaseConfiguration();

        // Überprüfe die Datenbankverbindung
        try {
            if (DatabaseManager.getConnection() != null) {
                System.out.println("Verbindung zur Datenbank hergestellt!");
            }
        } catch (SQLException e) {
            // Bei einem Fehler wird eine RuntimeException ausgelöst
            throw new RuntimeException("Datenbankverbindung konnte nicht hergestellt werden.", e);
        }
    }
}