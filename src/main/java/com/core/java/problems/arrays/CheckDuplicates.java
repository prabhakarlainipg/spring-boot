package com.core.java.problems.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckDuplicates {

    public static void main(String[] args) {
        Integer[] data = {1,2,3,4}; //Java Array declaration uses curly braces
        boolean hasDuplicates = false;
        Set<Integer> seen = new HashSet<>();
        for (Integer datum : data) {
            if(!seen.add(datum)){
                hasDuplicates = true;
                break;
            }
        }

        System.out.println(hasDuplicates);

        //USING STREAMS
       System.out.println(Arrays.stream(data).distinct().count() < data.length);

    }
}
