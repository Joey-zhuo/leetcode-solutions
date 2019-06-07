package com.jzz.solutions.math;

/**
 * Problem:
 * 7. Reverse Integer
 *
 * Desccription:
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * Examples:
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 *
 */
public class ReverseInteger {
    public int reverse(int x){
        int result = 0, remain;
        while(x != 0){
            remain = x % 10;
            x /= 10;
            if(Integer.MAX_VALUE/10 < result || (Integer.MAX_VALUE/10 == result && remain > 7)){
                return 0;
            }
            if(Integer.MIN_VALUE/10 > result || (Integer.MIN_VALUE/10 == result && remain < -8)){
                return 0;
            }
            result = result * 10 + remain;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(1534236469));
    }
}
