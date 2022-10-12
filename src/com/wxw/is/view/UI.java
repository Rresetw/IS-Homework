package com.wxw.is.view;

import com.wxw.is.algorithm.Caeser;
import com.wxw.is.algorithm.Hill;
import com.wxw.is.algorithm.Playfair;

import java.util.Scanner;

import static java.lang.Thread.currentThread;

/**
 * @author wxw
 * @create 2022-10-05 16:36
 */
public class UI {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String message = new String();
        String cipher = new String();
        int choose = 0;

        System.out.println("古典密码加密");
        System.out.println("请输入待加密的密码：");
        message = scanner.nextLine();
//        System.out.println("当前密码明文：");
//        System.out.println(message);
        System.out.println("--------------");

        while (choose != 4) {
            System.out.println("当前密码明文：");
            System.out.println(message);
            System.out.println("选择你的加密算法...");
            System.out.println("1. Caeser\n2. Playfair\n3. Hill\n4. 退出");
            System.out.println("请在此处键入选项：");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("您选择的是Caeser算法...");
                    System.out.println("请输入加密密钥(数字1 - 25):");
                    int cKey = scanner.nextInt();
                    cipher = Caeser.CaeserEncode(message, cKey);
                    System.out.println("使用Caeser加密后的密文：");
                    System.out.println(cipher);
                    break;
                case 2:
                    System.out.println("您选择的是Playfair算法...");
                    System.out.println("请输入加密密钥(关键字):");
                    scanner.nextLine();
                    String pKey = scanner.nextLine();
                    cipher = Playfair.playfairEncode(message, pKey);
                    break;
                case 3:
                    System.out.println("您选择的是Hill算法...");
                    System.out.println("请输入切分的长度m，我们会自动给你生成一个加密密钥：");
                    int hHey = scanner.nextInt();
                    cipher = Hill.hillEncode(message, hHey);
                    System.out.println("使用Hill加密后的密文：");
                    System.out.println(cipher);
                    break;
                case 4:
                    System.out.println("成功退出！");
                    break;
            }
            System.out.println("--------------");
            currentThread().sleep(1000);
        }
    }
}
