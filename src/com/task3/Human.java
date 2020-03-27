package com.task3;

import java.util.Objects;
import java.util.Random;

public abstract class Human {
    Random random = new Random();
    private boolean gender;
    private String name;
    private String lastName;
    private float height;
    private float weight;

    Human(boolean gender, String name, String lastName, float height, float weight) {
        this.gender = gender;
        this.name = name;
        this.lastName = lastName;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return gender == human.gender &&
                Float.compare(human.height, height) == 0 &&
                Float.compare(human.weight, weight) == 0 &&
                Objects.equals(name, human.name) &&
                Objects.equals(lastName, human.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, name, lastName, height, weight);
    }

    @Override
    public String toString() {
        return "Human{" +
                "gender=" + gender +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    boolean getGender() {
        return gender;
    }

    String getName() {
        return name;
    }

    String getLastName() {
        return lastName;
    }

    float getHeight() {
        return height;
    }

    float getWeight() {
        return weight;
    }

    boolean toSpendTime(Human human) {
        if (Math.abs((this.getHeight() - human.getHeight()) /
                ((this.getHeight() + human.getHeight()) / 2)) * 100 > 10) {
            return random.nextInt(100) < 85; //0.85
        } else {
            return random.nextInt(100) < 95; //0.95
        }
    }

    public abstract Human relations(Human human);

    public abstract boolean toTolerate(Human human);

    public abstract boolean toSpeak(Human human);

}
