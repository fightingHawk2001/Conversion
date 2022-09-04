package com.fighting.hawk.conversion.util;


public class StringUtil {
    // 格式化字符串
    public static String formatByRadix(String text, int radix) {
        StringBuilder string = new StringBuilder(text);
        int i = string.length();
        int count4 = ((i % 4 == 0) ? (i / 4 - 1) : (i / 4));
        int count3 = ((i % 3 == 0) ? (i / 3 - 1) : (i / 3));
        if (radix == 2) {
            // 二进制：四个为一组，用空格分隔
            for (int j = 1; j <= count4; j++) {
                string.insert(i - 4 * j, " ");
            }
        } else if (radix == 8) {
            // 八进制：三个为一组，用空格分隔
            for (int j = 1; j <= count3; j++) {
                string.insert(i - 3 * j, " ");
            }
        } else if (radix == 10) {
            // 十进制：三个为一组，用逗号分隔
            for (int j = 1; j <= count3; j++) {
                string.insert(i - 3 * j, ",");
            }
        } else if (radix == 16) {
            // 十六进制：四个为一组，用空格分隔
            for (int j = 1; j <= count4; j++) {
                string.insert(i - 4 * j, " ");
            }
        }
        return string.toString();
    }

    // 反格式化字符串，将字符串内的空格以及逗号都删除，得到一个完全合法的存放着数值的字符串
    public static String OppFormatByRadix(String text) {
        StringBuilder string = new StringBuilder(text);
        while (string.indexOf(" ") != -1)
            string.deleteCharAt(string.indexOf(" "));
        while (string.indexOf(",") != -1)
            string.deleteCharAt(string.indexOf(","));
        return string.toString();
    }
}
