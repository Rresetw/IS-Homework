package com.wxw.is.test;

/**
 * @author wxw
 * @create 2022-10-04 16:46
 */
public class Print {
    public static void main(String[] args) {
        char a = 97;
        int[] array = new int[]{a, a, a};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        // delete
        String message = new String("pay more money");
        message.replaceAll(" ", "");
        System.out.println(message);
        // 断开
        String[] sa = message.split("");
        for (int i = 0; i < sa.length; i++) {
            System.out.println(sa[i]);
        }

        System.out.println(5/2);

        //
        int k = (int)(Math.random()*100);
        System.out.println(k);

        //
        System.out.println(25 % 26);
    }
}
