package com.patterns.factory_method;

public class ComputerFactory {

    public static Computer getComputer(String type, String cpu, String ram) {
        if ("desktop".equalsIgnoreCase(type)) {
            return new Desktop(cpu, ram);
        } else if ("laptop".equalsIgnoreCase(type)) {
            return new Laptop(cpu, ram);
        }
        return null;
    }
}
