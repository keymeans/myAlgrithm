package common;

public class FindSubString {
    private String str;
    /** 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。*/
    public int lengthOfLongestSubstring(String s) {
        long length = s.length();
        int maxSubStrLength = 0;
        String maxSubStrCur = "";
        if(0!=length){
            maxSubStrLength = 1;
            maxSubStrCur = String.valueOf(s.charAt(0));
            int curLeft = -1;//当前比较字符左边界左侧
            int j = 1;
            while(j<length){
                //curLeft = maxSubStrCur.indexOf(s.charAt(j));
                while(j<length&&curLeft==-1){
                    curLeft = maxSubStrCur.indexOf(s.charAt(j));
                    if(curLeft == -1){
                        maxSubStrCur = maxSubStrCur + s.charAt(j);
                        j++;
                    }
                }
                if(maxSubStrCur.length()>maxSubStrLength){
                    maxSubStrLength = maxSubStrCur.length();
                }
                if(j<length && curLeft+1<length){//没有超过整个字符串范围
                    //compareSubStr = s.substring(curLeft+1,j+1)
                    maxSubStrCur = s.substring(curLeft+1,j+1);
                    s = s.substring(curLeft+1);
                    length = s.length();
                    j=j-curLeft;
                }
                //i = curLeft+1>i+1?curLeft+1:i+1;
                curLeft = -1;
            }
        }
        return maxSubStrLength;
    }
}
