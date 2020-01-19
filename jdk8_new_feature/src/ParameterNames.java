/**
 * @author liulusheng
 * @since 2019/11/12
 */

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Optional;

public class ParameterNames {
    public static void test(String a) {

    }

    public static void main(String[] args) throws Exception {

        Method method = ParameterNames.class.getMethod("main", String[].class);
        for (final Parameter parameter : method.getParameters()) {
            System.out.println("Parameter: " + parameter.getName());
        }
        Method method2 = A.class.getMethod("test", String.class);
        for (final Parameter parameter : method2.getParameters()) {
            System.out.println("Parameter: " + parameter.getName());
        }


        Method method1 = ParameterNames.class.getMethod("test", String.class);
        for (final Parameter parameter : method1.getParameters()) {
            System.out.println("Parameter: " + parameter.getName());
        }


/**
 * Optional
 */
        Optional<String> fullName = Optional.ofNullable(null);
        System.out.println("Full Name is set? " + fullName.isPresent());
        System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]"));
        System.out.println(fullName.map(s -> "Hey " + s + "!").

                orElse("Hey Stranger!"));
    }


}

class A {
    public static void test(String a) {

    }
}
