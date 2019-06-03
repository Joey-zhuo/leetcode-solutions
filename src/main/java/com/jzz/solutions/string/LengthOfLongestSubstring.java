package com.jzz.solutions.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Problems:
 * 3. Longest Substring Without Repeating Characters
 *
 * Description:
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s){
        if(null == s){
            return 0;
        }
        int longestLength = 0, start = 0, end = 0, length = s.length();
        char tmp;
        Integer index;
        Map<Character, Integer> map = new HashMap<>();
        //当尾指针到达字符串尾部或者剩下部分的长度小于已有的最长子串长度时，结束循环
        while(end < length && length - start > longestLength){
            tmp = s.charAt(end);
            index = map.get(tmp);
            if(null != index){//尾指针指向的字符已存在，则滑动窗口，将头指针设置为已有的下标的后一位，并从hash表中移除index前的所有记录
                for(int i = start; i < index; i++){
                    map.remove(s.charAt(i));
                }
                start = index + 1;
            }else{//若尾指针指向的字符不存在，则计算当前长度，并判断是否更新最长子串长度
                longestLength = Math.max(longestLength, end - start + 1);
            }
            map.put(tmp, end);//记录尾指针所指向的字符及其位置
            end++;
        }
        return longestLength;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }

}
