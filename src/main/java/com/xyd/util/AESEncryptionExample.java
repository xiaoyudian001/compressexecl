package com.xyd.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AESEncryptionExample {
    public static void main(String[] args) throws Exception {
        // Generate AES key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();

        // Plain text
        String plainText = "Hello, AES encryption!";

        // Encrypt
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        System.out.println("Original: " + plainText);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encryptedBytes));
        System.out.println("Decrypted: " + new String(decryptedBytes, StandardCharsets.UTF_8));
    }
}
