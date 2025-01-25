package auth.utilities;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class Argon2PasswordUtils {

    // Passwort hashen
    public static String hashPassword(String password) {
        Argon2 argon2 = Argon2Factory.create(); // Standard-Konfiguration
        try {
            return argon2.hash(2, 65536, 1, password.toCharArray()); // 2 Iterationen, 64 MB RAM, 1 Thread
        } finally {
            argon2.wipeArray(password.toCharArray()); // Sensible Daten aus dem Speicher löschen
        }
    }

    // Passwort validieren
    public static boolean verifyPassword(String password, String hashedPassword) {
        Argon2 argon2 = Argon2Factory.create();
        try {
            return argon2.verify(hashedPassword, password.toCharArray()); // Prüfen, ob das Passwort zum Hash passt
        } finally {
            argon2.wipeArray(password.toCharArray()); // Sensible Daten aus dem Speicher löschen
        }
    }
}
