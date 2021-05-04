import java.io.*;
import java.util.*;
import java.security.*; // needed for MessageDigest

public class Solution {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();
        
        // Getting instanse of MessageDigest
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        
        // Printing hash
        for (byte b : digest) {
            System.out.printf("%02x", Byte.toUnsignedInt(b));    
        }
    }
}
