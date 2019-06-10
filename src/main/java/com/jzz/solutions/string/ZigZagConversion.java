package com.jzz.solutions.string;

/**
 * Problem:
 * 6. ZigZag Conversion
 *
 * Description:
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 *
 * Examples:
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 */
public class ZigZagConversion {

    public String convert(String s, int numRows){
        if(null == s || s.length() <= 2 || numRows == 1){
            return s;
        }
        int cycleLength = 2 * numRows - 2;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            for(int j = i; j < s.length(); j+= cycleLength){
                result.append(s.charAt(j));
                int next = j + cycleLength - 2 * i;
                if(i != 0 && i != numRows - 1 && (2 * numRows - 2 - j) < s.length()){
                    result.append(s.charAt(2 * numRows - 2 - j));
                }
            }
        }
        return result.toString();
    }

}
