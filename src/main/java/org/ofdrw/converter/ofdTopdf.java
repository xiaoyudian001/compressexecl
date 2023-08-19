package org.ofdrw.converter;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ofdTopdf {
    public static void main(String[] args) {
        ConvertHelper.ofd2pdf(new File("E:\\project\\wj\\（2023)川10民终1218号民事裁定书（已签章）.ofd"),new File("E:\\project\\out\\2.pdf"));
    }

}
