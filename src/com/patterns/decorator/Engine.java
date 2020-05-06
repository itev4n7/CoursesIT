package com.patterns.decorator;

public class Engine extends CarDecorator {

    public Engine(Car car) {
        super(car);
    }

    public String tuning() {
        return super.tuning() + tuningEngine();
    }

    private String tuningEngine() {
        return " with engine";
    }
}
