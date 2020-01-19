package com.lls.inner_class;

/**
 * @author liulusheng
 * @since 2019/11/15
 */
public class HelloWorldAnonymousClasses {

    /**
     * 成员内部类 成员内部接口 ，尽管块里不能定义接口，但是可以将接口定义在成员内部类里
     */
    interface HelloWorld {
        public void greet();

        public void greetSomeone(String someone);
    }
    abstract class HelloWorld2{
       abstract void test();
    }

    public void sayHello() {

        class EnglishGreeting implements HelloWorld {
            String name = "world";

            public void greet() {
                greetSomeone("world");
            }

            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }

        HelloWorld englishGreeting = new EnglishGreeting();

/**
 * 匿名内部类是对接口的实现，匿名内部类其实是个表达式，因此后面需要加结束符号‘；’
 */
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";

            public void greet() {
                greetSomeone("tout le monde");
            }

            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };

        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "mundo";

            public void greet() {
                greetSomeone("mundo");
            }

            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };
        HelloWorld2 a=new HelloWorld2(){

            @Override
            void test() {
                System.out.println(1111);
            }
        };
        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        spanishGreeting.greet();
        a.test();
    }

    public static void main(String... args) {
        HelloWorldAnonymousClasses myApp =
                new HelloWorldAnonymousClasses();
        myApp.sayHello();
    }
}