package com.bw.util;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.AES;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * 对称加密算法
 * @author gogo
 */
public class AESUtil {
    /**
     * 密钥  16字节
     */
    private static final String ENCODE_KEY = "1234567812345678";
    private static final String IV_KEY = "0000000000000000";

    public static void main(String[] args) {

        // 加密
//        String encryptData = encryptFromString("你好", Mode.CBC, Padding.ZeroPadding);
//        System.out.println("加密后的数据：" + encryptData);
        //解密
        String decryptData = decryptFromString("p3okIWJZdhIePMqoTfl9KQ==", Mode.CBC, Padding.ZeroPadding);
        System.out.println("解密后的数据：" + decryptData);
    }

    public static String encryptFromString(String data, Mode mode, Padding padding) {
        AES aes;
        if (Mode.CBC == mode) {
            aes = new AES(mode, padding,
                    new SecretKeySpec(ENCODE_KEY.getBytes(), "AES"),
                    new IvParameterSpec(IV_KEY.getBytes()));
        } else {
            aes = new AES(mode, padding,
                    new SecretKeySpec(ENCODE_KEY.getBytes(), "AES"));
        }
        return aes.encryptBase64(data, StandardCharsets.UTF_8);
    }

    public static String decryptFromString(String data, Mode mode, Padding padding) {
        AES aes;
        if (Mode.CBC == mode) {
            aes = new AES(mode, padding,
                    new SecretKeySpec(ENCODE_KEY.getBytes(), "AES"),
                    new IvParameterSpec(IV_KEY.getBytes()));
        } else {
            aes = new AES(mode, padding,
                    new SecretKeySpec(ENCODE_KEY.getBytes(), "AES"));
        }
        byte[] decryptDataBase64 = aes.decrypt(data);
        return new String(decryptDataBase64, StandardCharsets.UTF_8);
    }

}

