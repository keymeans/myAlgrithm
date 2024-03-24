package common;

import java.util.Objects;

/**
 * Z字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 */
public class ConvertToZ {
    /**
     * 算法思路：生成numRows个可变长度字符串结构，其中第i个字符串存放转换后字符串结构中第i行字符数据，
     * 最后依次顺序拼接这numRows个字符串为最终字符串结果
     *
     * @param s       字符串
     * @param numRows 指定的分割行数
     * @return
     */
    public static String convertZ(String s, int numRows) {
        int length = s.length();
        char[] charS = s.toCharArray();//转换为字符数组
        if (length <= numRows || 1 == numRows) {
            return s;//若长度小于给定的行数，则直接返回输入结果
        }
        StringBuffer[] stringBuffers = new StringBuffer[numRows];
        //for(char charI: s.toCharArray()){
        int i = 0;
        int lastRow = 0;//记录上一个Z字形中一个循环末尾的位置，初始化为0
        while (i < length) {//只扫描一遍
            int numRowsI = lastRow;//numRowsI表示在一次循环中当前字符串的序列，范围从0到numRows-1
            while (numRowsI < numRows && i < length) {//从0号字符串到第numRows-1号字符串的正向归属
                if (Objects.nonNull(stringBuffers[numRowsI])) {
                    stringBuffers[numRowsI++].append(String.valueOf(charS[i++]));
                } else {
                    stringBuffers[numRowsI++] = new StringBuffer("").append(String.valueOf(charS[i++]));
                }
            }
            numRowsI--;
            while (--numRowsI >= 0 && i < length) {//从numRows-1号字符串到第0号字符串的逆向归属
                if (Objects.nonNull(stringBuffers[numRowsI])) {
                    stringBuffers[numRowsI].append(String.valueOf(charS[i++]));
                } else {
                    stringBuffers[numRowsI] = new StringBuffer("").append(String.valueOf(charS[i++]));
                }
            }
            lastRow = numRowsI + 2;//在第59行每次判断时减了1，numRowsI变成了-1,进入下次大循环要在加回1第基础上，再从下一个开始（再加1）
        }
        StringBuffer resStr = new StringBuffer();
        for (StringBuffer strBuffer : stringBuffers) {
            resStr = resStr.append(strBuffer);
        }
        return resStr.toString();
    }

    /**
     * 方法2:方法一：利用二维矩阵模拟
     * 设 nnn 为字符串 sss 的长度，r=numRowsr=\textit{numRows}r=numRows。对于 r=1r=1r=1（只有一行）或者 r≥nr\ge nr≥n（只有一列）的情况，答案与 sss 相同，我们可以直接返回 sss。对于其余情况，考虑创建一个二维矩阵，然后在矩阵上按 Z 字形填写字符串 sss，最后逐行扫描矩阵中的非空字符，组成答案。
     * <p>
     * 根据题意，当我们在矩阵上填写字符时，会向下填写 rrr 个字符，然后向右上继续填写 r−2r-2r−2 个字符，最后回到第一行，因此 Z 字形变换的周期 t=r+r−2=2r−2t=r+r-2=2r-2t=r+r−2=2r−2，每个周期会占用矩阵上的 1+r−2=r−11+r-2=r-11+r−2=r−1 列。
     * 因此我们有 ⌈nt⌉\Big\lceil\dfrac{n}{t}\Big\rceil⌈
     * t
     * n
     * ​
     * ⌉ 个周期（最后一个周期视作完整周期），乘上每个周期的列数，得到矩阵的列数 c=⌈nt⌉⋅(r−1)c=\Big\lceil\dfrac{n}{t}\Big\rceil\cdot(r-1)c=⌈
     * t
     * n
     * ​
     * ⌉⋅(r−1)。
     * <p>
     * 创建一个 rrr 行 ccc 列的矩阵，然后遍历字符串 sss 并按 Z 字形填写。具体来说，设当前填写的位置为 (x,y)(x,y)(x,y)，即矩阵的 xxx 行 yyy 列。初始 (x,y)=(0,0)(x,y)=(0,0)(x,y)=(0,0)，即矩阵左上角。若当前字符下标 iii 满足 i mod t<r−1i\bmod t<r-1imodt<r−1，则向下移动，否则向右上移动。
     * <p>
     * 填写完成后，逐行扫描矩阵中的非空字符，组成答案。
     * <p>
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/zigzag-conversion/solutions/1298127/z-zi-xing-bian-huan-by-leetcode-solution-4n3u/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convertByTwoMatrix(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        int t = r * 2 - 2;
        int middle = (n + t - 1);
        int c = (n + t - 1) / t * (r - 1);
        char[][] mat = new char[r][c];
        for (int i = 0, x = 0, y = 0; i < n; ++i) {
            mat[x][y] = s.charAt(i);
            if (i % t < r - 1) {
                ++x; // 向下移动
            } else {
                --x;
                ++y; // 向右上移动
            }
        }
        StringBuffer ans = new StringBuffer();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}
