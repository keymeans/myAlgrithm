import common.FindSubString;
import common.Palindrome;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        FindSubString findSubString = new FindSubString();
        String[] str = {"abca", "a", "ab", "abcd", "ababc", "aaaaa", "abcaaabcde", "pwwkew", "wkew", "wwkew"};
        int res = findSubString.lengthOfLongestSubstring("pwwkew");
        for (int i = 0; i < str.length; i++) {
            int result = findSubString.lengthOfLongestSubstring(str[i]);
            System.out.println(str[i] + ":" + result);
        }
        int int1 = 12321, int2 = 12, int3 = 123454321, int4 = 10, int5 = 1;
        System.out.println(int1 + ":" + Palindrome.isPalindromeByTransToString(int1));
        System.out.println(int2 + ":" + Palindrome.isPalindromeByTransToString(int2));
        System.out.println(int3 + ":" + Palindrome.isPalindromeByTransToString(int3));
        System.out.println(int4 + ":" + Palindrome.isPalindromeByTransToString(int4));
        System.out.println(int5 + ":" + Palindrome.isPalindromeByTransToString(int5));
    }
}
