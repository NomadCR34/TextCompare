package ir.amin.textcompare;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    public String hash(String text) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(text.getBytes());
        return new String(messageDigest.digest());
    }

}
