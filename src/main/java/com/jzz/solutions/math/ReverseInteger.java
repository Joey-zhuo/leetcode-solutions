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
        int result = 0, lastResult, remain;
        while(x != 0){
            remain = x % 10;
            x /= 10;
            lastResult = result;
            result = result * 10 ;
            System.out.println(result);
            result += remain;
            if((lastResult > 0 && result < 0) || (lastResult < 0 && result > 0)){//overflow
                return 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(1534236469));
//        System.out.println(Integer.toBinaryString(1056389758));
        System.out.println(Integer.MAX_VALUE);
    }
}
