package com.example.demo;


import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class MethodReference {
    public static Car create( final Supplier< Car > supplier ) {
        return supplier.get();
    }

    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.toString() );
    }

    public void follow( final Car another ) {
        System.out.println( "Following the " + another.toString() );
    }

    public void repair() {
        System.out.println( "Repaired " + this.toString() );
    }

    public static void main(String[] argv) throws Exception {
        // 调用构造方法
        Car car = Car.create(Car::new);
        List<Car> cars = Arrays.asList(car);
        // 通过类调用静态方法
        cars.forEach(Car::collide);
        // 通过类调用实例方法
        cars.forEach(Car::repair);
        // 调用构造方法
        Car police = Car.create(Car::new);
        // 通过实例调用实例方法
        cars.forEach(police::follow);
        cars.forEach(System.out::println);
    }
}

class Car {
    public static Car create( final Supplier<Car> supplier ) {
        return supplier.get();
    }

    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.toString() );
    }

    public void follow( final Car another ) {
        System.out.println( "Following the " + another.toString() );
    }

    public void repair() {
        System.out.println( "Repaired " + this.toString() );
    }
}

