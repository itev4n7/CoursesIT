package com.patterns.decorator;

public class Spoiler extends CarDecorator {
    public Spoiler(Car car) {
        super(car);
    }

    public String tuning() {
        return super.tuning() + spoiler();
    }

    private String spoiler() {
        return " with spoiler";
    }
}
