package auth.utilities.tools;

import auth.utilities.Argon2PasswordUtils;

public class PasswordHasher {

    public static void main(String[] args) {
        System.out.println(Argon2PasswordUtils.hashPassword("test0"));
        if (Argon2PasswordUtils.verifyPassword("test0", "$argon2i$v=19$m=65536,t=2,p=1$oilEM+eTfIH+AhgspLiVJw$7iux79EczBnCw2OrAEn17uz8zBgWVPeEK5ouSPrT8f4")) {
            System.out.println("OKAY.");
        } else {
            System.out.println("NOT OKAY.");
        }
    }

}
