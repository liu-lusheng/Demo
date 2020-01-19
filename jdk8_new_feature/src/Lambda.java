import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author liulusheng
 * @since 2019/11/12
 */
public class Lambda {
    public static class Car {
        public static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        public static void collide(final Car car) {
            System.out.println("Collided " + car.toString());
        }

        public void follow(final Car another) {
            System.out.println("Following the " + another.toString());
        }

        public void repair() {
            System.out.println("Repaired " + this.toString());
        }
    }

    public static void main(String[] args) {
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);
        cars.forEach(Car::collide);
        //该方法为成员方法，由于没有入参,因此可以通过className：method_name调用
        cars.forEach(Car::repair);
        final Car police = Car.create(Car::new);
        System.out.println(police.toString());
        //非静态方法，入参为Car
        /**
         * 下面的一行代码是foreach遍历，只是因为该方法只能对象调用，因此创建了一个对象来调用，polic的作用仅仅是调用
         * 该方法的入参Car实际上是list里的对象
         */
        cars.forEach(police::follow);
    }


}
