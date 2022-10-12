package com.wxw.is.util;
import org.testng.annotations.Test;

import java.security.Key;

/**
 * @author wxw
 * @create 2022-10-04 16:30
 * 矩阵乘法工具类
 */
public class Matrix {
    public static void main(String[] args) {
        int[][] Key = {{17, 17, 5}, {21, 18, 21}, {2, 2, 19}};
        int[] C = {15, 0, 24};
        int[] P = {11, 13, 18};
        System.out.println(C.length);
        System.out.println(Key.length);
        int[] result = mul(Key, C);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        //

        // 矩阵乘法
        int[][] A = {{-2, 4}, {1, -2}};
        int[][] B = {{2, 4}, {-3, -6}};
        int[][] result2 = mul(B, A);
        printMatrix(result2);

        // T
        int[][] Key_T = T(Key);
        printMatrix(Key_T);
        // Print
        printMatrix(Key);

    }

    // 矩阵乘法
    public static int[][] mul(int[][] A, int[][] B) {
        int row = A.length;
        int col = B[0].length;
        int center = B.length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < center; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static int[] mul(int[][] A, int[] B) {
        int[] result = new int[B.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                result[i] += A[i][j] * B[j];
            }
        }
        return result;
    }

    public static int[][] mul(int[] A, int[][] B) {
        return null;
    }

    // 转置矩阵
    public static int[][] T(int[][] X) {
        int rows = X.length, cols = X[0].length;
        int[][] X_T = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                X_T[j][i] = X[i][j];
            }
        }
        return X_T;
    }

    // print矩阵
    public static void printMatrix(int[][] X) {
        int rows = X.length, cols = X[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(X[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printMatrix(char[][] X) {
        int rows = X.length, cols = X[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(X[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 模26
    public static int[][] mod26(int[][] X) {
        int rows = X.length, cols = X[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                X[i][j] %= 26;
            }
        }
        return X;
    }

    // 数字矩阵转字符串
    public static String numMatrixToString(int[][] X) {
        StringBuffer cipherStringB = new StringBuffer();
        int rows = X.length, cols = X[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cipherStringB.append((char)(X[i][j] + 97));
            }
            cipherStringB.append(" ");
        }
        return new String(cipherStringB);
    }

    // 逆矩阵
    public static int[][] inverse(int[][] X) {
        return null;
    }

    // 寻找当前元素在矩阵的哪个位置
    public static String location(char[][] X, char c) {
        int rows = X.length, cols = X[0].length;
        String loc = "";
        // 如果是j当作i来加密
        if (c == 'j') {
            c = 'i';
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (X[i][j] == c) {
                   loc = i + " " + j;
                }
            }
        }
        return loc;
    }

    // 随机矩阵
    public static int[][] randomMatrix(int a, int b) {
        int[][] X = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                X[i][j] = (int)(Math.random() * 100);
            }
        }
        return X;
    }

    @Test
    public void test2() {
        int[][] X = randomMatrix(3, 3);
        printMatrix(X);
    }
}
