package common;

/**
 * 回文数相关
 * <p>
 * 回文数
 * 是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Palindrome {
    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * <p>
     * 例如，121 是回文，而 123 不是。
     * 判断一个正整数是否是回文数
     * 方法一：转换为字符串
     * 复杂度分析：时间：O（N/2），空间复杂度：O（N）
     * @param x
     * @return
     */
    public static boolean isPalindromeByTransToString(int x) {
        if (x < 0) {
            return false;
        }
        String res = String.valueOf(x);//将整型转换为字符串类型
        int i = 0;//两端扫描起始标记
        int j = res.length() - 1;//两端扫描末端标记
        while (i < j) {
            if (res.charAt(i) != res.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
