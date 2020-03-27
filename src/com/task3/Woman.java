package com.task3;

import java.util.Scanner;

public class Woman extends Human {
    Woman(String name, String lastName, float height, float weight) {
        super(false, name, lastName, height, weight);
    }

    @Override
    public boolean toSpeak(Human human) {
        System.out.println(this.getName() + " toSpeak " + human.getName());
        return true;
    }


    @Override
    public boolean toTolerate(Human human) {
        System.out.println(this.getName() + " toTolerate " + human.getName());
        if (this.getGender() == human.getGender()) {
            return random.nextInt(100) < 5;  //0.05
        } else {
            return random.nextInt(10) < 7; //0.7
        }
    }

    @Override
    public Human relations(Human human) {
        System.out.println(this.getName() + " relations " + human.getName());
        if (this.toSpeak(human) && this.toTolerate(human) && this.toSpendTime(human)) {
            if (this.getGender() != human.getGender()) {
                return toBirthHuman(human);
            }
        }
        System.out.println("Ooops... nothing happened");
        return null;
    }

    Human toBirthHuman(Human human) {
        boolean newGenger = random.nextInt(10) < 5;
        System.out.println("Enter child name(" + (newGenger ? "boy" : "girl") + ")");
        String newName = new Scanner(System.in).nextLine();
        float newHeight = (float) ((newGenger ? human.getHeight() : this.getHeight()) + 0.1 * ((newGenger ? this.getHeight() : human.getHeight()) - (newGenger ? human.getHeight() : this.getHeight())));
        float newWeight = (float) ((newGenger ? human.getWeight() : this.getWeight()) + 0.1 * ((newGenger ? this.getWeight() : human.getWeight()) - (newGenger ? human.getWeight() : this.getWeight())));
        return new Man(newName, human.getLastName(), newHeight, newWeight);
    }
}
