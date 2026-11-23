package com.core.java.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ParallelStreamDemo4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        long sum = LongStream.rangeClosed(1, 1000000)
                .parallel().sum();
        System.out.println(sum);

        IntStream.rangeClosed(1,10)
                .parallel()
                .forEach(n->
                        System.out.println(Thread.currentThread().getName()+"->"+n));
    }
}
