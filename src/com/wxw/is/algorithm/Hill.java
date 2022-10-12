package com.wxw.is.algorithm;

import com.sun.org.apache.xpath.internal.SourceTree;
//import org.testng.annotations.Test;

import java.security.MessageDigest;

import static com.wxw.is.util.Matrix.*;
import static com.wxw.is.util.UpperLower.allLower;

/**
 * @author wxw
 * @create 2022-10-03 19:55
 * Hill算法
 *  该算法选取m个连续的明文字母，并由m个密文字母代替
 *  不足m个字母默认补"x"
 *
 *  输入m，确定加密密钥矩阵维度
 */
public class Hill {
    public static void main(String[] args) {
        int[][] Key = {{17, 17, 5}, {21, 18, 21}, {2, 2, 19}};
        String message = new String("pay more money");
        System.out.println("明文：" + message);
//        String cipher = new String(Hill.hillDecode(message));
        String cipher = hillEncode(message, 3);
        System.out.println("密文：" + cipher);
    }

    /**
     * Hill加密
     * @param message 明文
     * @param m 切分的长度
     * @return 密文，加密密钥
     */
    public static String hillEncode(String message, int m) {
        // 0.0 全小写
        message = allLower(message);
        // 0.1 先随机生成一个加密密钥
        int[][] keyMatrix = randomMatrix(m, m);
//        int[][] keyMatrix = {{17, 17, 5}, {21, 18, 21}, {2, 2, 19}};
        // 1.0  打印加密密钥矩阵
        System.out.println("加密密钥：");
        printMatrix(keyMatrix);
        // 1.1  除去空格
        StringBuffer message_ = new StringBuffer(message.replaceAll(" ", ""));
        int rows = message_.length() / m;
        // 1.2 如果不满足m的倍数，补全
        if (message_.length() > rows * m) {
            // 补，并且更新rows
            rows += 1;
            int num = rows * m - message_.length();
            for (int i = 0; i < num; i++) {
                message_.append('x');
            }
        }
        // 1.3 声明明文ascii矩阵
        int[][] messageMatrix = new int[rows][m];
        // 2. 按m切分字符串并转化int数组
        for (int i = 0; i < rows; i++) {
            // 填充数组
            for (int j = 0; j < m; j++) {
                messageMatrix[i][j] = message_.charAt(i * m + j) - 97;
            }
        }
        // 3. 密钥矩阵和明文矩阵相乘获得密文矩阵
        int[][] cipherMatrix = mul(messageMatrix, T(keyMatrix));
        cipherMatrix = mod26(cipherMatrix);
        // 4. 密文矩阵转为英文
//        printMatrix(cipherMatrix); // 密文数字矩阵
        String cipherString = numMatrixToString(cipherMatrix);
        return cipherString;
    }

    // 解密
    public static String hillDecode(String cipher, int[][] Key) {
        // 1. 获得逆矩阵
        int[][] Key_inverse = inverse(Key);
        // 2. 密文转化为矩阵
        // 3. 密文矩阵和逆矩阵相乘
        // 4. 明文数字矩阵转为字符串，return
        return null;
    }


}
