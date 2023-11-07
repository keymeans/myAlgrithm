package org;

import common.FindSubString;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        FindSubString findSubString = new FindSubString();
        String [] str = {"abca","a","ab","abcd","ababc","aaaaa","abcaaabcde","pwwkew","wkew","wwkew"};
        int res = findSubString.lengthOfLongestSubstring("pwwkew");
        for(int i = 0;i<str.length;i++) {
            int result = findSubString.lengthOfLongestSubstring(str[i]);
            System.out.println(str[i]+":"+result);
        }
    }
}
