package common;

import java.util.HashSet;
import java.util.Set;

/**
 * 11. 盛最多水的容器
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 * 提示：
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class MaxArea {
    /**
     * 穷举法
     *
     * @param height
     * @return
     */
    public static int getMaxAreaByExhaustion(int[] height) {
        int length = height.length;
        if (2 == length) {// 只有2个柱子时，最大面积等于较小柱子大高，因为底=1
            return height[0] > height[1] ? height[1] : height[0];
        } else {
            int maxArea = 0;
            Set<Integer> giveUpSet = new HashSet<>();//存放抛弃的点
            int rightLine = length;//右侧边界
            int count = 0;
            for (int i = 0; i < rightLine; i++) {
                for (int j = i + 1; j < rightLine; j++) {
                    if (giveUpSet.contains(j)) {//J在抛弃集合里,继续下次循环
                        continue;
                    }
                    count++;
                    int minHeight = 0;
                    if (height[i] > height[j]) {
                        giveUpSet.add(j);//若当前高度较小，加入抛弃集合
                        minHeight = height[j];
                    } else {
                        minHeight = height[i];
                    }
                    int currentArea = minHeight * (j - i);//当前面积
                    if (currentArea > maxArea) {
                        maxArea = currentArea;//更替最大面积
                        //rightLine = j;
                    }
                }
            }
            System.out.println("count:" + count);
            return maxArea;
        }
    }

    /**
     * 双指针法，得先用单边控制变量法推导出这样是有效的
     * 时间复杂度：O（n）
     *
     * @param height
     * @return
     */
    public static int getMaxAreaByTwoPoint(int[] height) {
        int length = height.length;
        int area = 0;
        int midArea = 0;
        for (int i = 0, j = length-1; i < j; ) {
            midArea = (j - i) *Math.min(height[i],height[j]);
            area = Math.max(midArea,area);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return area;
    }
}
