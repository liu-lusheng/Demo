import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * i++ 和++i 赋值问题
 *
 * @author liulusheng
 * @since 2019/11/5
 */

public class CountExample {
    int i = 0;

    public void testNextAdd() {
        int j = i++;
        System.out.println("i=" + i + " j=" + j);

    }

    public void testFirstAdd() {
        int j = ++i;
        System.out.println("i=" + i + " j=" + j);

    }

    //验证i++和++i哪个是原子操作
    //测试后发现i++和++i都是非原子操作
    public void testNextAdd(ThreadPoolExecutor executor, int n) {
        for (int i = 0; i < n; i++) {
            executor.execute(() -> {
                testNextAdd();
            });
        }

    }

    public void testFirstAdd(ThreadPoolExecutor executor, int n) {
        for (int i = 0; i < n; i++) {
            executor.execute(() -> {
                testFirstAdd();
            });
        }

    }


    public static void main(String[] args) {
        CountExample example = new CountExample();
//        example.testFirstAdd(0);
//        example.testNextAdd(0);
//        //测试class文件的实际形式
//        int i = 0;
//        int j = i++;
//        System.out.println("i=" + i + " j=" + j);
//
//        int a = 0;
//        int b = ++a;
//        System.out.println("a=" + a + " b=" + b);
//
//        int c = 0;
//        int d = c--;
//        System.out.println("c=" + c + " d=" + d);
//
//        int x = 0;
//        int y = --x;
//        System.out.println("x=" + x + " y=" + y);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        example.testFirstAdd(executor, 1000);
        // example.testNextAdd(executor,1000);
        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        //example.i++;

        //    System.out.println(++example.i);

    }
}
