package com.jzz.solutions.dynamicprogramming;

/**
 * Problem:
 * 5. Longest Palindromic Substring
 *
 * Description:
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Examples:
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindrome {

    public String longestPalindrome(String s){
        if(null == s || s.isEmpty()){
            return s;
        }
        int length = s.length(), maxLength = 1, startIndex = 0, endIndex = 0;
        boolean[][] isPalindrome = new boolean[length][length];//isPalindrome[i][j]表示从s.substring(i, j+1)是否回文串
        isPalindrome[0][0] = true;
        for(int index = 1; index < length; index++){//initial
            isPalindrome[index][index] = true;
            isPalindrome[index - 1][index] = s.charAt(index - 1) == s.charAt(index);
            isPalindrome[index][index - 1] = isPalindrome[index - 1][index];
        }
        for(int start = length - 2; start >= 0; start--){
            for(int end = start + 1; end < length; end++){
                isPalindrome[start][end] = isPalindrome[start + 1][end - 1] && s.charAt(start) == s.charAt(end);
                if(isPalindrome[start][end] && end - start + 1 > maxLength){
                    maxLength = end - start + 1;
                    startIndex = start;
                    endIndex = end;
                }
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
    }

}
