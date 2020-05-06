package com.patterns.factory_method;

public class Laptop implements Computer {
    private final String cpu;
    private final String ram;

    public Laptop(String cpu, String ram) {
        this.cpu = cpu;
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                  "cpu='" + cpu + '\'' +
                  ", ram='" + ram + '\'' +
                  '}';
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }

    @Override
    public String getRam() {
        return this.ram;
    }
}
