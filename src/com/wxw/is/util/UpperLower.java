package com.wxw.is.util;

import org.testng.annotations.Test;

/**
 * @author wxw
 * @create 2022-10-05 15:13
 */
public class UpperLower {
    public static String allLower(String message) {
        StringBuffer t = new StringBuffer(message);
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) <= 90 && t.charAt(i) >= 65) {
                t.setCharAt(i, (char)(t.charAt(i) + 32));
            }
        }
        return t.toString();
    }

    @Test
    public void test1() {
        System.out.println(allLower("heEEk dfddI"));
    }
}
