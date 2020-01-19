package com.lls.inner_class;

/**
 * @author liulusheng
 * @since 2019/11/15
 */
public class LocalClassExample {

    //正则表达式 该变量和方法的的static同时去掉才行
    static String regularExpression = "[^0-9]";

    public static void validatePhoneNumber(
            String phoneNumber1, String phoneNumber2) {

        final int numberLength = 10;

        // Valid in JDK 8 and later:

        // int numberLength = 10;

        class PhoneNumber {

            String formattedPhoneNumber = null;

            PhoneNumber(String phoneNumber) {
                // numberLength = 7;
                String currentNumber = phoneNumber.replaceAll(
                        regularExpression, "");
                if (currentNumber.length() == numberLength)
                    formattedPhoneNumber = currentNumber;
                else
                    formattedPhoneNumber = null;
            }

            public String getNumber() {
                return formattedPhoneNumber;
            }

            // Valid in JDK 8 and later:

            public void printOriginalNumbers() {
                System.out.println("Original numbers are " + phoneNumber1 +
                        " and " + phoneNumber2);
            }
        }

        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

        // Valid in JDK 8 and later:

//        myNumber1.printOriginalNumbers();

        if (myNumber1.getNumber() == null)
            System.out.println("First number is invalid");
        else
            System.out.println("First number is " + myNumber1.getNumber());
        if (myNumber2.getNumber() == null)
            System.out.println("Second number is invalid");
        else
            System.out.println("Second number is " + myNumber2.getNumber());

    }

    /**
     *     局部接口不能在块里定义，除非局部内部类，这里的块表示方法体，for循环，if语句
     *     局部内部类和成员内部类一样，不能申明任何静态成员和方法,但是可以定义常量成员(包含静态和非静态)，如下
     */
    public static void sayGoodbyeInEnglish() {
        class EnglishGoodbye {
            public  static final String farewell = "Bye bye";
            public void sayGoodbye() {
                System.out.println(farewell);
            }
        }
        EnglishGoodbye myEnglishGoodbye = new EnglishGoodbye();
        myEnglishGoodbye.sayGoodbye();
    }
//    public void greetInEnglish() {
//        interface HelloThere {
//            public void greet();
//        }
//        class EnglishHelloThere implements HelloThere {
//            public void greet() {
//                System.out.println("Hello " + name);
//            }
//        }
//        HelloThere myGreeting = new EnglishHelloThere();
//        myGreeting.greet();
//    }
    public static void main(String... args) {
        validatePhoneNumber("123-456-7890", "456-7890");
        sayGoodbyeInEnglish();
    }
}
