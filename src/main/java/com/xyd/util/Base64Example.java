package com.xyd.util;

import java.util.Base64;

public class Base64Example {
    public static void main(String[] args) {
        String originalData = "Hello, Base64 encoding and decoding!";

        // Encode to Base64
        byte[] encodedBytes = Base64.getEncoder().encode(originalData.getBytes());
        String encodedText = new String(encodedBytes);

        // Decode from Base64
        byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
        String decodedText = new String(decodedBytes);

        System.out.println("Original: " + originalData);
        System.out.println("Encoded: " + encodedText);
        System.out.println("Decoded: " + decodedText);
    }
}

