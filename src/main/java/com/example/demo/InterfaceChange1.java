package com.example.demo;

/**
 * 接口可以有默认方法以及静态方法。
 * interface1跟interface2含有default方法，interface3没有default，
 * 类实现的接口中，所有含有default方法的接口要有继承关系。
 */
public class InterfaceChange1 implements Interface1,Interface2,Interface3 {
    public static void main(String[] args) {
        InterfaceChange1 class1 = new InterfaceChange1();
        class1.test();
        class1.test2();
        class1.test3();
    }
    /**
     * 可以通过super调用父级实现类的默认方法，通过Interface1.super调用Interface2的默认方法
     */
    public void test() { Interface1.super.test();}
}
/**
 * 含有default方法的interface1继承了含有default方法的interface2
 */
interface Interface1 //extends Interface2
{
    default void test() {
        System.out.println("Interface1");
    }
    default void test2() {
        System.out.println("Interface1");
    }
}
interface Interface2 {
    default void test() {
        System.out.println("Interface2");
    }
    default void test3() {
        System.out.println("Interface2");
    }
}
interface Interface3{
}
// -----------------------------------------------------------
/**
 * 一个接口继承多个接口，且这些接口含有同名的默认方法的接口没有继承关系
 * 可以通过重写那个同名的默认方法来解决异常
 */
interface Interface4 extends Interface5,Interface6{
    /**
     * 同名默认方法，解决异常。
     */
    default void test() {}
}
interface Interface5 {
    default void test() {}
}
interface Interface6 {
    default void test() {}
}
// -----------------------------------------------------------
class InterfaceChange2 implements Interface7,Interface8 {
    /**
     * 重写接口中拥有相同方法名的default方法test
     */
    public void test() {
        Interface7.super.test();
    }
}

/**
 * Interface4跟Interface5没有继承关系，且拥有同名的default方法
 */
interface Interface7
{
    default void test() {

    }
}
interface Interface8 {
    default void test() {
        System.out.println("Interface8");
    }
    default void test1() {
        System.out.println("Interface8.test1");
    }
}