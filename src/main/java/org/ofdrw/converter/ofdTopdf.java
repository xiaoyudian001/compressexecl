package org.ofdrw.converter;
import java.io.File;
public class ofdTopdf {
    public static void main(String[] args) {
        ConvertHelper.ofd2pdf(new File("E:\\project\\wj\\预交诉讼费通知单（已签章）.ofd"),new File("E:\\project\\wj\\test13.pdf"));
    }

}
