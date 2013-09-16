package org.glassfish.web;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderb
 * Date: 9/16/13
 */
public class PasswordGenerator {

    private static String hashPassword(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes("UTF-8")); // Change this to "UTF-16" if needed
        byte[] digest = md.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String output = bigInt.toString(16);

        return output;
    }

    public static void main(String[] args) throws Exception {
        String password = hashPassword("admin");
        System.out.println(password);
    }
}
