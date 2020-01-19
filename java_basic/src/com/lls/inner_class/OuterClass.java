package com.lls.inner_class;

/**
 * 内部类分为静态内部类和非静态内部类
 * 非静态内部类分为成员内部类、局部内部类、匿名内部类
 * 局部内部类定义在方法体里
 * 由于内部类和外部类都是不同的类，因此他们可以定义同样的属性名和成员方法，之间没有任务联系
 *
 * @author liulusheng
 * @since 2019/11/13
 */

public class OuterClass {
    private String name = "outClass";
    private static int age = 18;

    public void print() {
        System.out.println("outerClass " + name + " " + age);
    }

    public static void staticPrint() {
        System.out.println("outerClass " + age);
    }

    public void getStaticInnerClass() {
        StaticInerCls staticInerCls = new StaticInerCls();
        staticInerCls.print();
    }

    /**
     * 静态内部类特性：
     * 只能访问外部类的静态变量和静态方法，非静态的不能访问
     */

    //静态内部类 static nested class
     static class StaticInerCls {
        private String name = "staticInnerClass";

        public void print() {
            System.out.println("this is static nested class " + name);
            staticPrint();
        }

        public void getOuterClass() {
            OuterClass outerClass = new OuterClass();
            outerClass.print();
            outerClass.getStaticInnerClass();
        }

    }

    /**
     * 成员内部类
     */
    class InerCls {
        private String name;

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        //静态内部类的生成以下四种
//        StaticInerCls staticInerCls = new StaticInerCls();
//        staticInerCls.print();
//
//        StaticInerCls staticInerCls1 = new OuterClass.StaticInerCls();
//        staticInerCls1.print();
//
//        OuterClass.StaticInerCls staticInerCls2 = new OuterClass.StaticInerCls();
//        staticInerCls2.print();

        OuterClass.StaticInerCls staticInerCls3 = new StaticInerCls();
        staticInerCls3.print();

        staticInerCls3.getOuterClass();

    }
}