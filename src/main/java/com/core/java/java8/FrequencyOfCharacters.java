package com.core.java.java8;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

//groupingBy(classifier)
/// / Map<K, List<T>>, using the toList() downstream
//
//groupingBy(classifier, downstream)
//// Map<K, D>, which is what you used
//
//groupingBy(classifier, mapFactory, downstream)

//// choose the Map type, e.g. TreeMap::new or LinkedHashMap::new
public class FrequencyOfCharacters {
    public static void main(String[] args) {
        String str = "programming";

        Map<Character, List<Character>> map =
                str.chars().mapToObj(c->(char)c)
                        .collect(
                                Collectors.groupingBy(
                                        Function.identity())
                        );

        System.out.println(map);

        Map<Character, Long> map1 =
                str.chars().mapToObj(c->(char) c)
                        .collect(
                                Collectors.groupingBy(
                                        Function.identity(), counting())
                        );

        System.out.println(map1);

        Map<Character, Long> map2 =
                str.chars().mapToObj(c->(char) c)
                        .collect(
                                Collectors.groupingBy(
                                        Function.identity(), LinkedHashMap::new, counting())
                        );

        System.out.println(map2);
    }
}
