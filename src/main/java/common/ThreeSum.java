package common;

import java.util.*;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 升级版本：第二重循环和第三重循环使用双指针，相向而行
 */
public class ThreeSum {
    public static List<List<Integer>> threeSumInorderUpgrade(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        int[] numsInOrder = Arrays.stream(nums).sorted().toArray();//排序
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numsInOrder.length; i++) {
            if (0 == i || numsInOrder[i] != numsInOrder[i - 1]) {//在同一次循环中过滤相同的元素，避免产生重复的结果
                int k = numsInOrder.length - 1;
                for (int j = i + 1; j < numsInOrder.length; j++) {
                    if (i + 1 == j || numsInOrder[j] != numsInOrder[j - 1]) {//在同一次循环中过滤相同的元素，避免产生重复的结果
                        while (j < k && numsInOrder[i] + numsInOrder[j] + numsInOrder[k] > 0)
                            k--;
                        if(j==k)
                            break;
                        if (0 == numsInOrder[i] + numsInOrder[j] + numsInOrder[k]) {
                            res = new ArrayList<>();
                            res.add(numsInOrder[i]);
                            res.add(numsInOrder[j]);
                            res.add(numsInOrder[k]);
                            resList.add(res);
                        }
                    }
                }
            }

        }
        return resList;
    }

    /**
     * threeSum1 = new int[]{-1, 0, 1, 2, -1, -4};
     * threeSum1 = new int[]{-4, -1,-1, 0, 1, 2};
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSumInorder(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        int[] numsInOrder = Arrays.stream(nums).sorted().toArray();//排序
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numsInOrder.length; i++) {
            if (0 == i || numsInOrder[i] != numsInOrder[i - 1]) {//在同一次循环中过滤相同的元素，避免产生重复的结果
                for (int j = i + 1; j < numsInOrder.length; j++) {
                    if (i + 1 == j || numsInOrder[j] != numsInOrder[j - 1]) {//在同一次循环中过滤相同的元素，避免产生重复的结果
                        for (int k = j + 1; k < numsInOrder.length; k++) {
                            if (j + 1 == k || numsInOrder[k] != numsInOrder[k - 1]) {
                                if (0 == numsInOrder[i] + numsInOrder[j] + numsInOrder[k]) {
                                    res = new ArrayList<>();
                                    res.add(numsInOrder[i]);
                                    res.add(numsInOrder[j]);
                                    res.add(numsInOrder[k]);
                                    resList.add(res);
                                }
                            }
                        }
                    }
                }
            }

        }
        return resList;
    }

    /**
     * method of exhaustion
     * 穷举法
     * threeSum1 = new int[]{-1, 0, 1, 2, -1, -4};
     *
     * @param nums
     * @return
     * @Deperated
     */
    public static List<List<Integer>> threeSumExhaustion(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Set<Integer> repetiveSet = new HashSet<>();
        Set<Integer> unRepeatedSet = new HashSet<Integer>();
        for (int num : nums) {//找出数组中重复的元素
            if (!unRepeatedSet.isEmpty()) {
                if (unRepeatedSet.contains(num)) {
                    repetiveSet.add(num);
                }
            }
            unRepeatedSet.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
//            unRepeatedSet.add(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
//                unRepeatedSet.add(nums[j]);
                for (int k = j + 1; k < nums.length; k++) {
//                    unRepeatedSet.add(nums[k]);
//                    if (unRepeatedSet.contains(nums[k])) {//判断是否有重复
//                        repetiveSet.add(nums[k]);
//                    } else
                    if (0 == nums[i] + nums[j] + nums[k]) {
                        res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[k]);
                        resList.add(res);
                    }
                }

            }
        }
        if (!repetiveSet.isEmpty()) {//对重复的元素做特殊处理
            for (Integer repeN : repetiveSet) {
                if (unRepeatedSet.contains(-repeN - repeN)) {
                    res = new ArrayList<>();
                    res.add(repeN);
                    res.add(repeN);
                    res.add(repeN + repeN);
                    resList.add(res);
                }
            }
        }
        return resList;
    }
}
