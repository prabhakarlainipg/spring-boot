package com.core.java.java8;

import java.util.function.*;


public class FunctionalInterfaces {
    public static void main(String[] args) {
        // 1. Predicate: check a condition
        Predicate<Integer> isAdult = age -> age >= 18;

        System.out.println(isAdult.test(20)); // true
        System.out.println(isAdult.test(15)); // false

        // 2. Function: transform an input into a result
        Function<String, Integer> findLength = String::length;

        System.out.println(findLength.apply("Java")); // 4

        // 3. Consumer: perform an action without returning a result
        Consumer<String> greet =
                name -> System.out.println("Hello, " + name);

        greet.accept("Prabhakar"); // Hello, Prabhakar

        // 4. Supplier: provide a result without receiving an input
        Supplier<String> defaultName = () -> "Guest";

        System.out.println(defaultName.get()); // Guest

        UnaryOperator<Integer> sq =  n-> n*n;

        System.out.println(sq.apply(4));//16

        BinaryOperator<Integer> add = (a,b)->a+b;
        System.out.println(add.apply(4,5)); //9

    }
}
