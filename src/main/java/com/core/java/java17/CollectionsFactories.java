package com.core.java.java17;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionsFactories {

    public static void main(String[] args) {
        List<String> languages = List.of("Java", "Python", "Go");

        Set<Integer> numbers = Set.of(10, 20, 30);

        Map<Integer, String> employees = Map.of(
                1, "Asha",
                2, "Ravi"
        );

        System.out.println(languages);

        System.out.println(numbers);

        System.out.println(employees);


        //THESE COLLECTIONS ARE UNMODIFIABLE

        //languages.add("JavaScript"); //UnsupportedOperationException

        List<Integer> squares = List.of(1, 2, 3, 4)
                .stream()
                .map(n -> n * n)
                .toList(); // this returns UnModifieable List

        System.out.println(squares); // [1, 4, 9, 16]

       // squares.add(5); //UnsupportedOperationException

        List<String> lines = Arrays.stream("Java\nSpring\nSQL"
                        .split("\n"))
                .toList();

        System.out.println(lines); // [Java, Spring, SQL]
    }
}
