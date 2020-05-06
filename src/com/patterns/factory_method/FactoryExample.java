package com.patterns.factory_method;

public class FactoryExample {
    public static void main(String[] args) {
        Computer laptop = ComputerFactory.getComputer("laptop", "3.2 GHz", "16 GB");
        Computer desktop = ComputerFactory.getComputer("desktop", "4.1 GHz", "32 GB");

        System.out.println(laptop);
        System.out.println(desktop);
    }
}
