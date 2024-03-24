package common;

/**
 * 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 * 提示：
 * -231 <= x <= 231 - 1
 */
public class IntegerInversion {
    /**
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long res = 0;
        double MinValue = Math.pow(-2, 31);
        double MaxValue = Math.pow(2, 31);
        if (x <= MinValue || x > MaxValue - 1) {
            return 0;
        }
        if (x > -10 && x < 10) { //10以内的反转后就是x本身
            return x;
        }
        int quotient = x;//商
        while (quotient != 0) {
            int remainder = quotient % 10;//余数
            if (res * 10.0 > MinValue || res * 10.0 < MaxValue - 1) {//超过整型类型判断
                res = res * 10 + remainder; //最终结果，向左移位，并加上新的余数
            }else {//超过整型表示的范围，则返回0
                return 0;
            }
            quotient = quotient / 10;//获取下一个位数值
        }
        if (res <= MinValue || res > MaxValue - 1) {
            return 0;
        }
        x= (int) res;//将结果转换为整型
        return x;
    }
}
