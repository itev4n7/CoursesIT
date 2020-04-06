package com.task3;

import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        /*
        parameters for test:
        M->M
        man Igor Dor 175 70
        man Misha Hort 180 75

        M->W
        man Aleksandr Sort 180 79
        woman Vika Golys 169 54

        W->W
        woman Dasha Solid 175 58
        woman Liza Gornya 170 56

        W->M
        woman Alina Doret 170 55
        man Denys Procod 175 67
        */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two partners(gender(man/woman), name, lastName, height, weight)");
        System.out.print("partner1 = ");
        String[] partner1 = scanner.nextLine().trim().split("\\s+");
        System.out.print("partner2 = ");
        String[] partner2 = scanner.nextLine().trim().split("\\s+");
        Human human1 = defineGender(partner1);
        Human human2 = defineGender(partner2);
        System.out.println(compatibilityTest(human1, human2));
    }

    private static Human compatibilityTest(Human human1, Human human2) {
        return human1.relations(human2);
    }

    private static Human defineGender(String[] partner) {
        Human human;
        if (partner[0].equalsIgnoreCase("man")) {
            human = new Man(partner[1], partner[2], Float.parseFloat(partner[3]), Float.parseFloat(partner[4]));
        } else {
            human = new Woman(partner[1], partner[2], Float.parseFloat(partner[3]), Float.parseFloat(partner[4]));
        }
        return human;
    }
}