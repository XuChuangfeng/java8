package com.example.demo;

/**
 * 函数式接口：接口中仅有一个抽象方法（默认方法跟静态方法不计入）
 * Lambda表达式是用于函数式接口的
 * @author chuan
 */
public class LambdaTest1 {
    public static void main(String[] args) {
        // 在java8之前，只能通过以下方法,匿名内部类的方式实例化一个接口
        LambdaInterface1 lambdaInterface11 = new LambdaInterface1() {
            @Override
            public void test() {
                System.out.println("使用匿名内部类的方式!");
            }
        };
        lambdaInterface11.test();

        LambdaInterface1 lambdaInterface12 = () -> System.out.println("使用lambda表达式简化！");
        lambdaInterface12.test();

        // ()中可以不指定参数的类型，会自动推断参数类型
        LambdaInterface2 lambdaInterface21 = (str) -> System.out.println("使用Lambda表达式简化！");
        lambdaInterface21.test("");
        lambdaInterface21.defaultTest();
    }
}
@FunctionalInterface
interface LambdaInterface1 {
    void test();
}
@FunctionalInterface
interface LambdaInterface2 {
    void test(String str);
    default void defaultTest() {
        System.out.println("default function in functional interface!");
    }
}