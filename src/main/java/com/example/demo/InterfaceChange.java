package com.example.demo;

/**
 * interface1跟interface2含有default方法，interface3没有default，
 * 类实现的接口中，所有含有default方法的接口必须有继承关系。
 */
public class InterfaceChange implements Interface1,Interface2,Interface3 {
    public static void main(String[] args) {
        InterfaceChange class1 = new InterfaceChange();
        class1.test();
        class1.test1();
        class1.test2();
    }
}
/**
 * 含有default方法的interface1继承了含有default方法的interface2
 */
interface Interface1 extends Interface2{
    default void test() {
        System.out.println("Interface1");
    }
    default void test1() {
        System.out.println("Interface1");
    }
}
interface Interface2 {
    default void test() {
        System.out.println("Interface2");
    }
    default void test2() {
        System.out.println("Interface2");
    }
}
interface Interface3{
}

