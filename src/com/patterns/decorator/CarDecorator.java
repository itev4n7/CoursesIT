package com.patterns.decorator;

public abstract class CarDecorator implements Car {
    private Car car;

    public CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public String tuning() {
        return car.tuning();
    }
}
