package auth;

import auth.utilities.Argon2PasswordUtils;
import gdb.DatabaseManager;
import gdb.GlobalDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

/**
 * Diese Klasse bietet Authentifizierungsfunktionen, einschließlich der Überprüfung von Benutzernamen und Passwörtern.
 */
public class Authentication {

    /**
     * Validiert, ob der angegebene Benutzername und das Passwort mit den in der Datenbank gespeicherten Werten übereinstimmen.
     *
     * @param username       Der Benutzername, der überprüft werden soll.
     * @param clear_password Das Passwort im Klartext, das überprüft werden soll.
     * @return True, wenn Benutzername und Passwort korrekt sind, andernfalls False.
     */
    public static boolean validate(String username, String clear_password) {
        // Versuche, eine Verbindung zur Datenbank herzustellen
        try (Connection conn = DatabaseManager.getConnection()) {
            // SQL-Abfrage, um die Benutzerdaten anhand des Benutzernamens abzurufen
            String query = "SELECT * FROM " + GlobalDatabase.databaseConfiguration.getUser_auth_table() +
                    " WHERE username = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username); // Setze den Benutzernamen in die Abfrage
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        // Holen der gespeicherten Werte aus der Datenbank
                        String db_username = rs.getString("username");
                        String db_password = rs.getString("password");

                        // Überprüfen, ob Passwort und Benutzername übereinstimmen
                        return Argon2PasswordUtils.verifyPassword(clear_password, db_password) &&
                                Objects.equals(db_username, username);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Protokolliere Fehler bei der Datenbankverbindung oder Abfrage
        }
        return false; // Rückgabe von false, falls die Validierung fehlschlägt
    }
}
