package com.task3;

public class Man extends Human {
    Man(String name, String lastName, float height, float weight) {
        super(true, name, lastName, height, weight);
    }

    @Override
    public boolean toSpeak(Human human) {
        System.out.println(this.getName() + " toSpeak " + human.getName());
        if (this.getGender() == human.getGender()) {
            return random.nextInt(10) < 5; //0.5
        } else {
            return true;
        }
    }

    @Override
    public boolean toTolerate(Human human) {
        System.out.println(this.getName() + " toTolerate " + human.getName());
        if (this.getGender() == human.getGender()) {
            return random.nextInt(1000) < 56; //0.056
        } else {
            return random.nextInt(10) < 7; //0.7
        }
    }

    @Override
    public Human relations(Human human) {
        System.out.println(this.getName() + " relations " + human.getName());
        if (this.toSpeak(human) && this.toTolerate(human) && this.toSpendTime(human)) {
            if (this.getGender() != human.getGender()) {
                if (!human.getGender()) {
                    return ((Woman) human).toBirthHuman(this);
                }
            }
        }
        System.out.println("Ooops... nothing happened");
        return null;
    }
}
