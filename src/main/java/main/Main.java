package main;

import common.*;

import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        FindSubString findSubString = new FindSubString();
//        String[] str = {"abca", "a", "ab", "abcd", "ababc", "aaaaa", "abcaaabcde", "pwwkew", "wkew", "wwkew"};
//        int res = findSubString.lengthOfLongestSubstring("pwwkew");
//        for (int i = 0; i < str.length; i++) {
//            int result = findSubString.lengthOfLongestSubstring(str[i]);
//            System.out.println(str[i] + ":" + result);
//        }
//        int int1 = 12321, int2 = 12, int3 = 123454321, int4 = 10, int5 = 1;
//        System.out.println(int1 + ":" + Palindrome.isPalindromeByTransToString(int1));
//        System.out.println(int2 + ":" + Palindrome.isPalindromeByTransToString(int2));
//        System.out.println(int3 + ":" + Palindrome.isPalindromeByTransToString(int3));
//        System.out.println(int4 + ":" + Palindrome.isPalindromeByTransToString(int4));
//        System.out.println(int5 + ":" + Palindrome.isPalindromeByTransToString(int5));
////        Set<HashSet<int[]>> setInt = new HashSet<HashSet<int[]>>();
//        Set<int[]> setInt = new HashSet<>();
//        setInt.add(new int[]{1, 0});
//        setInt.add(new int[]{0, 1});
//        setInt.contains(1);
//        Iterator<int[]> iterator = setInt.iterator();
//        while (iterator.hasNext()) {
//            threeSum1 = iterator.next();
//            for (int ele : threeSum1) {
//                System.out.print(ele+",");
//            }
//            System.out.println("");
//        }
        List<List<Integer>> resThreeSum;
        int[] threeSum1 = new int[]{-1, 0, 1, 2, -1, -4};
        threeSum1 = new int[]{-1, 0, 1, 2, -1, -4};
        int [] MaxBox = new int[]{1,8,6,2,5,4,8,3,7};
        int[] array = BigDataStruct.numsBigData;
        //int[] array1 = BigDataStruct2.intArrayBig;
//        int ress = MaxArea.getMaxAreaByExhaustion(array);//ress:285279501  ress:285279501
        Set<int[]> setInt = new HashSet<>();
        setInt.add(threeSum1);
        setInt.add(MaxBox);
//        setInt.add(array);
//        setInt.add(array1);
        //testMaxAreaByExhaustion(setInt);
        //Arrays.stream(array).mapToObj((index,element)->String.format("%d:%d",index+1,element)).forEach(System.out::println);
//        Arrays.stream(array).forEach(x->System.out.println(x));
        testMaxAreaByTwoPoint(setInt);
    }

    /**
     * 测试盛最多水的容器
     * @param arrayInputList
     */
    public static void testMaxAreaByExhaustion(Set<int[]> arrayInputList){
        arrayInputList.forEach(setI->System.out.println(setI.length+",resMax:"+MaxArea.getMaxAreaByExhaustion(setI)));//使用lambda表达式遍历
    }

    /**
     * 测试双端队列法
     * @param arrayInputList
     */
    public static void testMaxAreaByTwoPoint(Set<int[]> arrayInputList){
        arrayInputList.forEach(setI->System.out.println(setI.length+",resMax:"+MaxArea.getMaxAreaByTwoPoint(setI)));//使用lambda表达式遍历
    }

}
/*
count:4498500
array.length:3000
ress:285279501

count:11404
array.length:3000
ress:285279501

 */