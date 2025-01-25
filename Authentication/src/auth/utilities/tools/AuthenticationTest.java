package auth.utilities.tools;

import auth.Authentication;
import gdb.GlobalDatabase;

public class AuthenticationTest {

    /**
     * Main function for the database test
     *
     * @param args
     */
    public static void main(String[] args) {
        GlobalDatabase.init();
        //valid
        if (Authentication.validate("test", "test")) {
            System.out.println("Info is valid!");
        } else {
            System.out.println("Info is invalid!");
        }

        //invalid
        if (Authentication.validate("test", "test09")) {
            System.out.println("Info is valid!");
        } else {
            System.out.println("Info is invalid!");
        }

    }

}
