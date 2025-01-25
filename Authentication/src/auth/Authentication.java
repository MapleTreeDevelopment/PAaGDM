package auth;

import auth.utilities.Argon2PasswordUtils;
import gdb.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class Authentication {

    public static boolean validateClear(String username, String clear_password) {
        try (Connection conn = DatabaseManager.getConnection()) {
            String query = "SELECT * FROM user_auth WHERE username = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        String db_username = rs.getString("username");
                        String db_password = rs.getString("password");
                        return Argon2PasswordUtils.verifyPassword(clear_password, db_password) &&
                                Objects.equals(db_username, username);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
