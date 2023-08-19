//package com.xyd.util;
//
//import org.bouncycastle.crypto.engines.SM4Engine;
//import org.bouncycastle.crypto.params.KeyParameter;
//import org.bouncycastle.crypto.params.ParametersWithIV;
//import org.bouncycastle.crypto.CipherParameters;
//import org.bouncycastle.jce.provider.BouncyCastleProvider;
//import java.security.Security;
//import org.bouncycastle.crypto.generators.SCrypt;
//
//public class SM4Example {
//    public static void main(String[] args) {
//        Security.addProvider(new BouncyCastleProvider());
//
//        String plainText = "Hello, SM4 encryption and decryption!";
//        String password = "password";
//
//        // Generate key from password
//        byte[] key = SCrypt.generate(password.getBytes(), null, 16384, 8, 1, 32);
//
//        // Generate random IV
//        byte[] iv = new byte[16]; // IV size for SM4 is 16 bytes
//
//        // Encrypt
//        byte[] encrypted = encrypt(plainText.getBytes(), key, iv);
//
//        // Decrypt
//        byte[] decrypted = decrypt(encrypted, key, iv);
//
//        System.out.println("Original: " + plainText);
//        System.out.println("Encrypted: " + new String(encrypted));
//        System.out.println("Decrypted: " + new String(decrypted));
//    }
//
//    public static byte[] encrypt(byte[] input, byte[] key, byte[] iv) {
//        CipherParameters params = new ParametersWithIV(new KeyParameter(key), iv);
//        SM4Engine engine = new SM4Engine();
//        engine.init(true, params);
//        byte[] output = new byte[engine.getOutputSize(input.length)];
//        int len = engine.processBlock(input, 0, input.length, output, 0);
//        engine.doFinal(output, len);
//        return output;
//    }
//
//    public static byte[] decrypt(byte[] input, byte[] key, byte[] iv) {
//        CipherParameters params = new ParametersWithIV(new KeyParameter(key), iv);
//        SM4Engine engine = new SM4Engine();
//        engine.init(false, params);
//        byte[] output = new byte[engine.getOutputSize(input.length)];
//        int len = engine.processBlock(input, 0, input.length, output, 0);
//        engine.doFinal(output, len);
//        return output;
//    }
//}
