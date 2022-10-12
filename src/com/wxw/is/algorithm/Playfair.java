package com.wxw.is.algorithm;

import com.wxw.is.util.Matrix;
import org.testng.annotations.Test;

import static com.wxw.is.util.Matrix.location;
import static com.wxw.is.util.Matrix.printMatrix;
import static com.wxw.is.util.UpperLower.allLower;

/**
 * @author wxw
 * @create 2022-10-03 19:55
 */
public class Playfair {
    public static void main(String[] args) {
        String message = new String("we are discovered save yourself");
        System.out.println("明文：" + message);
        String keyword = new String("monarchy");
        playfairEncode(message, keyword);

    }

    /**
     * Playfair加密 —— 双字母组合加密
     * @param message
     * @param keyword
     * @return
     * 出现重复明文默认插入k，循环替换
     */
    public static String playfairEncode(String message, String keyword) {
        // 0. 全小写
        message = allLower(message);
        // 1. 关键字生成的字母矩阵
        char[][] charMatrix = generateMatrix(keyword);
        System.out.println("关键字:" + keyword + "\n字母矩阵：");
        printMatrix(charMatrix);
        // 2. 分割明文
        String messageSplit = splitMessage(message);
//        System.out.println(messageSplit);
        System.out.println("分组明文：");
        // 3. 按两个一组加密
        StringBuffer cipher = new StringBuffer();
        for (int i = 0; i < messageSplit.length(); i += 2) {
            char a = messageSplit.charAt(i);
            char b = messageSplit.charAt(i + 1);
            // 返回字符串为"x y"形式
            String aLocation = location(charMatrix, a);
            String bLocation = location(charMatrix, b);
//            System.out.println(aLocation);
//            System.out.println(bLocation);
            // 获取坐标
            int arow = Integer.parseInt(Character.toString(aLocation.charAt(0)));
            int acol = Integer.parseInt(Character.toString(aLocation.charAt(2)));
            int brow = Integer.parseInt(Character.toString(bLocation.charAt(0)));
            int bcol = Integer.parseInt(Character.toString(bLocation.charAt(2)));
            // 如果在同行
            if (arow == brow) {
                cipher.append(charMatrix[arow][(acol + 1) % 5]);
                cipher.append(charMatrix[brow][(bcol + 1) % 5]);
            } else if (acol == bcol) {  // 如果在同列
                cipher.append(charMatrix[(arow + 1) % 5][acol]);
                cipher.append(charMatrix[(brow + 1) % 5][bcol]);
            } else {    // 如果不在同一行也不在同一列
                cipher.append(charMatrix[arow][bcol]);
                cipher.append(charMatrix[brow][acol]);
            }
            // 添加空格
            cipher.append(" ");
            // 打印明文
            System.out.print(messageSplit.subSequence(i, i+2) + " ");
        }
        System.out.println("\n分组密文：");
        System.out.println(cipher);
        return new String(cipher);
    }

    // 处理明文并分割
    public static String splitMessage(String message) {
        // 1. 先去空,再将j变成i进行加密
        message = message.replaceAll(" ", "");
        message = message.replaceAll("j", "i");
        // 2. 出现重复明文默认插入k
        StringBuffer messageB = new StringBuffer(message);
        for (int i = 0; i < messageB.length() - 1; i += 2) {
            if (messageB.charAt(i) == messageB.charAt(i+1)) {
                messageB.insert(i+1, 'k');
            }
        }
        // 3.保证模2为0
        if (messageB.length() % 2 != 0) {
            messageB.append('k');
        }
        return new String(messageB);
    }

    // 由关键字生成字母矩阵5 * 5
    public static char[][] generateMatrix(String keyword) {
        // 全小写
        keyword = allLower(keyword);
        // 只保留I，如果加密的message中含有J，一律当成I来加密
        String total = new String("abcdefghiklmnopqrstuvwxyz");
        char[][] matrix = new char[5][5];
        // 1. 删除关键字中含有的字母，注意特殊情况
        for (int i = 0; i < keyword.length(); i++) {
            char c = keyword.charAt(i);
            if (c == 'j') {
                total = total.replaceAll("i", "");
            } else {
                total = total.replaceAll(Character.toString(c), "");
            }
        }
        // 2. 填充
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int index = i * 5 + j;
                if (index < keyword.length()) {
                    matrix[i][j] = keyword.charAt(index);
                } else {
                    matrix[i][j] = total.charAt(index - keyword.length());
                }
            }
        }
        return matrix;
    }

    // Playfair解密
    public static String playfairDecode(String message, String keyword) {
        return null;
    }
    @Test
    public void test1() {
        String message = new String("we are discovered save youself");
        String keyword = new String("monarchy");
        generateMatrix(keyword);
    }

    @Test
    public void teat2() {
        char c = 'j';
        if (c == 'j') System.out.println("true");

        String s = new String("hhhhhhhkkkkkk");
        s = s.replaceAll("h", "");
        System.out.println(s);
    }

    @Test
    public void test3() {
        String message = new String("balloon");
        message = splitMessage(message);
        System.out.println(message);
    }
}
