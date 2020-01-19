package com.lls.collection;

import java.util.*;

/**
 * 递归问题
 *
 * @author liulusheng
 * @since 2019/11/1
 */
public class RecursionExample {
    public static void test(List<Integer> list) {

        if (!list.isEmpty()) {
            list.remove(list.size() - 1);
            if (list.size() == 1) {
                return;
            }
            test(list);
        }
        list.forEach(System.out::print);
    }

    public static void test(int i) {
        if (i > 1) {
            i--;
            if (i == 1) {
                return;
            }
            test(i);
        }
        System.out.println(i);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        list.forEach(System.out::print);
        System.out.println();
        System.out.println("-----------");
        RecursionExample.test(list);

        System.out.println();
        System.out.println("********");
        RecursionExample.test(4);
    }



   /* public static void main(String[] args) {

        Enumeration names;
        String key;

        // Creating a Hashtable
        Hashtable<String, String> hashtable =
                new Hashtable<String, String>();

        // Adding Key and Value pairs to Hashtable
        hashtable.put("Key1","Chaitanya");
        hashtable.put("Key2","Ajeet");
        hashtable.put("Key3","Peter");
        hashtable.put("Key4","Ricky");
        hashtable.put("Key5","Mona");
        System.out.println( hashtable.toString());
//        names = hashtable.keys();
//        while(names.hasMoreElements()) {
//            key = (String) names.nextElement();
//            System.out.println("Key: " +key+ " & Value: " +
//                    hashtable.get(key));
//        }
    }*/
}
