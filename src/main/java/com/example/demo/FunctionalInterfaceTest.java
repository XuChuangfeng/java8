package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 函数式接口(Functional Interface)就是一个具有一个方法的普通接口。
 * 函数式接口可以被隐式转换为lambda表达式。
 * Java8之前就存在的函数式接口：java.lang.Runnable java.util.concurrent.Callable java.security.PrivilegedAction java.util.Comparator java.io.FileFilter java.nio.file.PathMatcher  java.lang.reflect.InvocationHandler
 * java.beans.PropertyChangeListener  java.awt.event.ActionListener javax.swing.event.ChangeListener
 * Java8提供了43个函数式接口：java.util.function.*
 * @author XuChuangFeng
 */
public class FunctionalInterfaceTest {

    public static void main(String[] argv) throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 输出所有数据
        filterAndSort(list, integer -> true);

        // 输出全部偶数
        filterAndSort(list, integer -> integer%2 == 0);

        // 输出全部大于9的数
        filterAndSort(list, integer -> integer > 9);
    }

    public static void filterAndSort(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(item -> {
            if(predicate.test(item)) {
                System.out.println(item);
            }
        });
    }
}
