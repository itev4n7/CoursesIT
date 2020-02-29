package com.task1;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        task6_6(scanner.nextLine());

    }

    static void task1(String[] args) {
        System.out.println("Hi, " + args[0]);
    }

    static void task2(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.print(args[i] + " ");
        }
    }

    static void task3(String[] args) {
        Stream.of(args).forEach(System.out::println);
        Stream.of(args).forEach(System.out::print);
    }

    static void task4(String[] args) {
        String pass = "qwerty12345";
        System.out.println(args[0].equals(pass));
    }

    static void task5(String[] args) {
        AtomicInteger sum = new AtomicInteger();
        Stream.of(args)
                .mapToInt(Integer::parseInt)
                .forEach(sum::addAndGet);
        for (int i = 0; i < args.length - 1; i++) {
            System.out.print(args[i] + " + ");
        }
        System.out.println(args[args.length - 1] + " = " + sum.get());
    }

    static void task6_1(String str) {
        Pattern.compile(" ")
                .splitAsStream(str)
                .mapToInt(Integer::parseInt)
                .forEach(i -> {
                    if (i % 2 == 0) {
                        System.out.print(i + " ");
                    }
                });
        Pattern.compile(" ")
                .splitAsStream(str)
                .mapToInt(Integer::parseInt)
                .forEach(i -> {
                    if (i % 2 != 0) {
                        System.out.print(i + " ");
                    }
                });

    }

    static void task6_2(String str) {
        Pattern.compile(" ")
                .splitAsStream(str)
                .mapToInt(Integer::parseInt)
                .max().ifPresent(System.out::println);
        Pattern.compile(" ")
                .splitAsStream(str)
                .mapToInt(Integer::parseInt)
                .min().ifPresent(System.out::println);
    }

    static void task6_3(String str) {
        Pattern.compile(" ")
                .splitAsStream(str)
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 3 == 0 || i % 9 == 0)
                .forEach(System.out::println);
    }

    static void task6_4(String str) {
        Pattern.compile(" ")
                .splitAsStream(str)
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 5 == 0 && i % 7 == 0)
                .forEach(System.out::println);
    }

    static void task6_5(String str) {
        Pattern.compile(" ")
                .splitAsStream(str)
                .filter(s -> s.length() == 3)
                .filter(s -> {
                    String[] val = s.split("");
                    return val[0].equals(val[1]) && val[1].equals(val[2]);
                })
                .forEach(System.out::println);
    }

    static void task6_6(String str) {
        Pattern.compile(" ")
                .splitAsStream(str)
                .filter(s -> s.length() == 4 &&
                        (s.charAt(0) + s.charAt(3)) ==
                                (s.charAt(1) + s.charAt(2)))
                .forEach(System.out::println);
    }
}