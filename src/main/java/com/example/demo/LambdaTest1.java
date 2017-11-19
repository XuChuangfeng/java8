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

        // 只有一个入参，可以把参数的括号省略
        LambdaInterface3 lambdaInterface31 = str -> {System.out.println("使用lambda表达式简化！");return str;};
        System.out.println(lambdaInterface31.test("hehe"));

        // 方法体只有一条语句的时候，可以将返回值都省略,同时也需要将{}省略；
        // 会自动把语句执行的结果当作返回值，str做为入参，也作为返回值
        LambdaInterface3 lambdaInterface32 = str -> "hello," + str;
        System.out.println(lambdaInterface32.test("hehe"));

        // lambda表达式访问了本地变量，跟匿名内部类一样，本地变量必须是final类型，否则编译异常。
        // 如果没有加final，程序会自动为你加上final声明。
        String finalStr = "123";
        LambdaInterface3 lambdaInterface33 = str -> "hello," + finalStr;
        String test = lambdaInterface33.test("");
        System.out.println(test);
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
@FunctionalInterface
interface LambdaInterface3 {
    String test(String str);
}