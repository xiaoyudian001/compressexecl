package com.xyd.util;

import lombok.SneakyThrows;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DemoUtils {
    public static final String ALGORITHM = "SHA";
    //参数可选SHA/SHA1/SHA-1/SHA-256/MD5

    public static String SHA256Encrypt(String orignal) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (null != md) {
            byte[] origBytes = orignal.getBytes();
            md.update(origBytes);
            byte[] digestRes = md.digest();
            String digestStr = getDigestStr(digestRes);
            return digestStr;
        }
        return null;
    }

    private static String getDigestStr(byte[] origBytes) {
        String tempStr = null;
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < origBytes.length; i++) {
            tempStr = Integer.toHexString(origBytes[i] & 0xff);
            if (tempStr.length() == 1) {
                stb.append("0");
            }
            stb.append(tempStr);
        }
        return stb.toString();
    }

    @SneakyThrows
    public static void main(String[] args) {
        String nonce = "aabbccdd";
        String appsecret = "3q66301b7710307yziz1t1x5wbgu4p5j8dtr4mzy";
        Long curTime = System.currentTimeMillis();
        System.out.println(curTime.toString());
        String input = nonce + appsecret + curTime;
        System.out.println(SHA256Encrypt(input));
    }
}
