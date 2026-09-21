package com.core.java;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


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
    }
}
