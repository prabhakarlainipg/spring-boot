package com.core.java.java8;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {

        List<Integer> nums = List.of(1,2,3,4,5);

        List<Integer> nums2 = Arrays.asList(1,2,3,4,5);


        List<Integer> evens = nums.stream()
                .filter(a->a%2==0)
                .collect(Collectors.toList());

        System.out.println(evens);
        System.out.println(nums.stream().filter(s->s%2==0).count());


        List<List<Integer>> groups = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );

        List<Integer> result = groups.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(result); // [1, 2, 3, 4, 5, 6]

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        System.out.println(sum); // 10


        List<String> words = Arrays.asList(
                "java", "spring", "java", "sql", "spring", "java"
        );

        Map<String, Long> counts = words.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap :: new,
                        Collectors.counting()
                ));
        System.out.println(counts);


        Map<Integer, List<String>> byLength = words.stream()
                .collect(Collectors.groupingBy(String::length,
                        HashMap::new,
                        Collectors.toList()));

        System.out.println(byLength);


        Optional<String > optional = "Prabhakar".describeConstable();


        System.out.println(optional.orElseGet(()->"Not Found"));
        System.out.println(optional.orElse("Not Found"));


    }
}
