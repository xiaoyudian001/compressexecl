package com.xyd.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class xydCommomUtils {
    private static final String zhPattern = "[\\u4e00-\\u9fa5]";
    //100KB
    byte[] a = new byte[1024 * 100];

    public static void main(String[] args) throws Exception {
        ArrayList<xydCommomUtils> objects = new ArrayList<>();
        while (true) {
            objects.add(new xydCommomUtils());
            Thread.sleep(3000);
        }
//        byte[] byteArray = "Hello, World!".getBytes();
//
//        for (byte b : byteArray) {
//            System.out.print(b + " ");
//        }
//
//        System.out.println(); // 换行
//
//        // 或者将字节数组转换为十六进制字符串再打印
//        String hexString = byteArrayToString(byteArray);
//        System.out.println(hexString);


    }

    /**
     * 中文下载地址转码
     *
     * @param str
     * @param charset
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String encode(String str, String charset) throws UnsupportedEncodingException {
        Pattern p = Pattern.compile(zhPattern);
        Matcher m = p.matcher(str);
        StringBuffer b = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(b, URLEncoder.encode(m.group(0), charset));
        }
        m.appendTail(b);
        return b.toString();
    }

    public static String bytesToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(String.format("%02X ", b)); // 转换为十六进制
        }
        return stringBuilder.toString();
    }

    public static String byteArrayToString(byte[] byteArray) {
        StringBuilder sb = new StringBuilder();
        for (byte b : byteArray) {
            sb.append((char) b); // 将字节转换为字符并添加到字符串中
        }
        return sb.toString();
    }
}
