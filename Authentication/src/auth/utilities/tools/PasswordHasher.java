package auth.utilities.tools;

import auth.utilities.Argon2PasswordUtils;

public class PasswordHasher {

    public static void main(String[] args) {
        System.out.println(Argon2PasswordUtils.hashPassword("donsprop"));
        if (Argon2PasswordUtils.verifyPassword("test0", "1$/2l8H/exZu+vDD/4OF0gjA$2lEJx7+fZCWPrrvX9pucZWn8ysSYTrim+TlgVDqwcnw")) {
            System.out.println("OKAY.");
        } else {
            System.out.println("NOT OKAY.");
        }
    }

}
