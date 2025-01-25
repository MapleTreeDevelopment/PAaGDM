package auth.utilities;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

/**
 * Utility-Klasse für die Passwortverarbeitung mit dem Argon2-Algorithmus.
 */
public class Argon2PasswordUtils {

    /**
     * Erstellt einen sicheren Hash aus einem Passwort.
     *
     * @param password Das Passwort, das gehasht werden soll.
     * @return Der generierte Hash als String.
     */
    public static String hashPassword(String password) {
        Argon2 argon2 = Argon2Factory.create(); // Standardkonfiguration von Argon2
        try {
            // Argon2-Parameter: 2 Iterationen, 64 MB RAM, 1 Thread
            return argon2.hash(2, 65536, 1, password.toCharArray());
        } finally {
            // Sensible Daten (Passwort im Speicher) sicher löschen
            argon2.wipeArray(password.toCharArray());
        }
    }

    /**
     * Überprüft, ob ein Passwort zu einem gespeicherten Hash passt.
     *
     * @param password       Das eingegebene Passwort.
     * @param hashedPassword Der gespeicherte Hash des Passworts.
     * @return True, wenn das Passwort mit dem Hash übereinstimmt, sonst False.
     */
    public static boolean verifyPassword(String password, String hashedPassword) {
        Argon2 argon2 = Argon2Factory.create();
        try {
            // Verifiziert, ob der Passwort Hash mit dem eingegebenen Passwort übereinstimmt
            return argon2.verify(hashedPassword, password.toCharArray());
        } finally {
            // Sensible Daten löschen
            argon2.wipeArray(password.toCharArray());
        }
    }
}
