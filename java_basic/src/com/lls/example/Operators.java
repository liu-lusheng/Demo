package com.lls.example;

/**
 * @author liulusheng
 * @since 2019/11/19
 */
// Java program to illustrate
// shift operators
public class Operators {
    public static void main(String[] args) {

        //Initial values
        int a = 1;
        int b = 2;

        // bitwise and
        // 0101 & 0111=0101 = 5
        System.out.println("a&b = " + (a & b));

        // bitwise or
        // 0101 | 0111=0111 = 7
        System.out.println("a|b = " + (a | b));

        // bitwise xor
        // 0101 ^ 0111=0010 = 2
        System.out.println("a^b = " + (a ^ b));

        // bitwise and
        // ~0101=1010
        // will give 2's complement of 1010 = -6
        System.out.println("~a = " + ~a);

        // can also be combined with
        // assignment operator to provide shorthand
        // assignment
        // a=a&b
        a &= b;
        System.out.println("a= " + a);


        int c = 5;
        int d = -10;

        // left shift operator
        // 0000 0101<<2 =0001 0100(20)
        // similar to 5*(2^2)
        System.out.println("c<<2 = " + (c << 2));

        // right shift operator
        // 0000 1010 >> 2 =0000 0010(2)
        // similar to 10/(2^2)=2 为啥
        //-10/(2^2)=-3
        /**
         * 10的绝对值：0000 0000 0000 0000 0000 00000 0000 1010
         * 补码：1111 1111 1111 1111 1111 1111 1111 0101
         * 补码+1： 1111 1111 1111 1111 1111 1111 1111 0110    -10的二进制
         * 右移2为，负数高位补1： 1111 1111 1111 1111 1111 1111 1111 1101 右移2位后的负数二进制
         * 补码-1：1111 1111 1111 1111 1111 1111 1111 1100
         * 补码：0000 0000 0000 0000 0000 00000 0000 0011 为3
         */

        System.out.println("d>>2 = " + (d >> 2));

        // unsigned right shift operator
        System.out.println("d>>>2 = " + (d >>> 2));
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(-10 >>> 1);
        System.out.println(Math.pow(2, 29));
        byte b1 = -128;
        byte b2 = -128;
        //为啥会自动转型
        byte b3 = (byte) (b1 + b2);
        System.out.println(b3);
        System.out.println(Math.round(-11.6));
    }
}
