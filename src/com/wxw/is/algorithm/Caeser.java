package com.wxw.is.algorithm;


/**
 * @author wxw
 * @create 2022-10-03 19:55
 */
public class Caeser {
    public static void main(java.lang.String[] args) {
        char a = 97;
        int K = 17;
        String message = new String("Gaul Is divided into three parts");
        System.out.println("明文：" + message);
        String cipher = Caeser.CaeserEncode(message, K);
        System.out.println("密文：" + cipher);
        System.out.println("------------------------------\nCaeser解密：");
        for (K = 1; K < 26; K++) {
            System.out.print(K + ". ");
            System.out.println(Caeser.CaeserDecode(cipher, K));
        }
    }

    // 加密
    public static String CaeserEncode(String message, int K) {
        // 先全变成小写 然后同时加密
        StringBuffer cipher = new StringBuffer(message);
        for (int i = 0; i < cipher.length(); i++) {
            if (cipher.charAt(i) <= 90 && cipher.charAt(i) >= 65) {
                cipher.setCharAt(i, (char)((cipher.charAt(i) + 32 - 97 + K) % 26 + 97));
            } else if (cipher.charAt(i) <= 122 && cipher.charAt(i) >= 97) {
                cipher.setCharAt(i, (char)((cipher.charAt(i) - 97 + K) % 26 + 97));
            }
        }
        return cipher.toString();
    }

    // 解密
    public static String CaeserDecode(String cipher, int K) {
        // 解密，把区间固定在0-25
        StringBuffer message = new StringBuffer(cipher);
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) <= 122 && message.charAt(i) >= 97) {
                message.setCharAt(i, (char)((message.charAt(i) - 97 - K + 26) % 26 + 97));
            }
        }
        return message.toString();
    }
}
