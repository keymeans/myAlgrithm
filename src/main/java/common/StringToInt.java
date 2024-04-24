package common;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 字符串转整型
 * 8. 字符串转换整数 (atoi)
 * 中等
 * 相关标签
 * 相关企业
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * 函数 myAtoi(string s) 的算法如下：
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * 示例 1：
 * 输入：s = "42"
 * 输出：42
 * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
 * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 * 第 3 步："42"（读入 "42"）
 * 解析得到整数 42 。
 * 由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
 * 示例 2：
 * 输入：s = "   -42"
 * 输出：-42
 * 解释：
 * 第 1 步："   -42"（读入前导空格，但忽视掉）
 * 第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
 * 第 3 步："   -42"（读入 "42"）
 * 解析得到整数 -42 。
 * 由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
 * 示例 3：
 * 输入：s = "4193 with words"
 * 输出：4193
 * 解释：
 * 第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
 * 第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 * 第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
 * 解析得到整数 4193 。
 * 由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
 * 提示：
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 */
public class StringToInt {
    /**
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        s = s.trim();//去除前后空格
        int res = 0;
        int digitSqe = 1; //数字序列
        boolean negativeSign = false;
        for (int i = 0; i < s.length(); i++) {
            if ('-' == s.charAt(i)) {
                negativeSign = true;
            }
            if (Character.isDigit(s.charAt(i))) {
                res = res * 10;
                //将char类型转换为String类型，再转换为int类型
                res = res + Integer.parseInt(String.valueOf(s.charAt(i)));
            }
        }
        res = negativeSign ? (-res) : res;
        if (res > Math.pow(2, 31) - 1) {
            res = (int) Math.pow(2, 31) - 1;
        } else if (res < Math.pow(-2, 31)) {
            res = (int) Math.pow(-2, 31);
        }
        return res;
    }


    @Test
/**
 * 单元测试
 */ public void testStringToTest() {
        String[] str = {"589 sisf sdif ","words and 987", "-9999999", "-123", "0023", "1", "-213", "my name is 123", "today is a -367 day", "sdfjsd -99999999"};
        /**
         * lambd 表达式来遍历字符串数组
         */
        Arrays.stream(str).forEach(strI -> System.out.println(strI + ":自做:" + myAtoi(strI)+",官方:"+myAtoiAuto(strI)));
//         Arrays.stream(str).forEach(strI -> System.out.println("--官方--："+strI + ":" + myAtoiAuto(strI)));

    }
 /**
  * 作者：力扣官方题解
  链接：https://leetcode.cn/problems/string-to-integer-atoi/solutions/183164/zi-fu-chuan-zhuan-huan-zheng-shu-atoi-by-leetcode-/
  来源：力扣（LeetCode）
  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
  */
    public int myAtoiAuto(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }


}