package com.xyd.util;
import javax.crypto.Cipher;
import java.security.*;

public class RSAExample {
    public static void main(String[] args) throws Exception {
        // Generate key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Original data
        String originalData = "Hello, RSA encryption and signing!";

        // Encrypt with public key
        PublicKey publicKey = keyPair.getPublic();
        byte[] encryptedBytes = encryptRSA(originalData, publicKey);

        // Decrypt with private key
        PrivateKey privateKey = keyPair.getPrivate();
        String decryptedData = decryptRSA(encryptedBytes, privateKey);

        System.out.println("Original: " + originalData);
        System.out.println("Encrypted: " + new String(encryptedBytes));
        System.out.println("Decrypted: " + decryptedData);
    }

    public static byte[] encryptRSA(String data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data.getBytes());
    }

    public static String decryptRSA(byte[] encryptedData, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedData);
        return new String(decryptedBytes);
    }
}


