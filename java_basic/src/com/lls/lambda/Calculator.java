package com.lls.lambda;

import java.util.function.Function;

/**
 * lambda不能用于抽象类的抽象方法，只能用于接口，接口的所有方法都隐式的作为抽象方法
 *
 * @author liulusheng
 * @since 2019/11/15
 */
public class Calculator {

    interface IntegerMath {

        abstract int operation(int a, int b);

    }

    public int operateBinary(int a, int b, IntegerMath op) {

        return op.operation(a, b);
    }

    public static void main(String... args) {

        Calculator myApp = new Calculator();
        IntegerMath addition = new IntegerMath() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        };
        IntegerMath subtraction = (a, b) -> a - b;
//        不能用于抽象类的抽象方法
//        IntegerMaths aa=(a,b)->a-b;
        System.out.println("40 + 2 = " +
                myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " +
                myApp.operateBinary(20, 10, subtraction));
    }
}

abstract class IntegerMaths {

    abstract int operation(int a, int b);

}