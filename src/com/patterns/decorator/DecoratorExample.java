package com.patterns.decorator;

public class DecoratorExample {
    public static void main(String[] args) {
        Car car = new Spoiler(new Engine(new TuningCar()));
        System.out.println(car.tuning());
    }
}
