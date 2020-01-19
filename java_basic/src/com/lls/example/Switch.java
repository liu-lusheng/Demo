package com.lls.example;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;

/**
 * 验证switch支持哪些类型
 * switch支持byte short int以及他们的包装类型（因为会隐式转为int） char Character String enun
 *
 * @author liulusheng
 * @since 2019/11/18
 */
public class Switch {
    static boolean a;

    public static void verifyIntandInteger() {
        int i = 1;
        Integer integer = Integer.valueOf(1);
        switch (i) {
            case 1:
                System.out.println("passable");
                break;
            default:
        }
        switch (integer) {
            case 1:
                System.out.println("passable");
                break;
            default:
        }
    }

    public static void verifyByte() {
        byte b = 127;
        Byte b1 = new Byte(b);
        switch (b) {
            case 1:
                System.out.println("passable");
                break;
            default:
        }

        switch (b1) {
            case 1:
                System.out.println("passable");
                break;
            default:
        }

    }
//报错
/*    public static void verifyLong() {
        long l=1;
        switch (l){

        }
    }*/


    public static void main(String[] args) {
//        verifyIntandInteger();
//        verifyByte();
//        System.out.println(a);
//        System.out.println((int)'墅');
        //System.out.println(2&5);
        char a = (char) (Math.pow(2, 16));
        System.out.println(Math.pow(2,16));
        String b = String.valueOf(a);
        char d='字';
        String c=String.valueOf(d);
        System.out.println(c.getBytes(Charset.forName("utf-8")).length);//打印3个字节
        System.out.println(c.getBytes(Charset.forName("unicode")).length);//打印4个字节
        System.out.println(c.getBytes().length);//打印3个字节
        System.out.println((int)d);


    }

}
