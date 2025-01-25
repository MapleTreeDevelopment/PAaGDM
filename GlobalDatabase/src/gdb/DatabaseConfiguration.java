package gdb;

import gdb.utilities.BinaryFileManager;
import org.apache.mina.core.buffer.IoBuffer;

/**
 * Diese Klasse speichert die Konfiguration für die Datenbankverbindung.
 * Die Konfigurationsdaten werden aus einer Datei gelesen, die mit `BinaryFileManager` geladen wird.
 */
public class DatabaseConfiguration {

    // Pfade für Konfigurationsdateien
    public static final String config_path = "./filestore/config.gdb";
    public static final String secrets_path = "./filestore/secrets.gdb";

    // Datenbankkonfigurationsparameter
    private final String host;
    private final String database;
    private final String username;
    private final String password;
    private final int port;
    private final String user_gamedata_table;
    private final String user_auth_table;

    /**
     * Konstruktor: Liest die Konfigurationsdaten aus einer Datei und initialisiert die Felder.
     */
    public DatabaseConfiguration() {
        IoBuffer buffer = BinaryFileManager.getConfig();
        assert buffer != null : "Konfigurationsdatei konnte nicht geladen werden.";

        // Initialisiere die Konfigurationsparameter
        port = buffer.getInt(); // Port der Datenbank
        host = BinaryFileManager.getString(buffer); // Host-Adresse
        username = BinaryFileManager.getString(buffer); // Datenbankbenutzername
        password = BinaryFileManager.getString(buffer); // Datenbankpasswort
        database = BinaryFileManager.getString(buffer); // Datenbankname
        user_auth_table = BinaryFileManager.getString(buffer); // Tabelle für Benutzerauthentifizierung
        user_gamedata_table = BinaryFileManager.getString(buffer); // Tabelle für Spieldaten
    }

    /**
     * @return Die Host-Adresse der Datenbank.
     */
    public String getHost() {
        return host;
    }

    /**
     * @return Der Name der Datenbank.
     */
    public String getDatabase() {
        return database;
    }

    /**
     * @return Der Benutzername für die Datenbankverbindung.
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return Das Passwort für die Datenbankverbindung.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return Der Port der Datenbank.
     */
    public int getPort() {
        return port;
    }

    /**
     * @return Der Name der Tabelle für Spieldaten.
     */
    public String getUser_gamedata_table() {
        return user_gamedata_table;
    }

    /**
     * @return Der Name der Tabelle für Benutzerauthentifizierung.
     */
    public String getUser_auth_table() {
        return user_auth_table;
    }
}
