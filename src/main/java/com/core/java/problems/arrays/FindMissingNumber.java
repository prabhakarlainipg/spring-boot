package com.core.java.problems.arrays;

import java.util.Arrays;

public class FindMissingNumber {

    public static void main(String[] args) {

        Integer[] data = {0,1,3};

        System.out.println(findMissingNumber(data));
    }

    private static Integer findMissingNumber(Integer[] data) {
        Integer sum = Arrays.stream(data).reduce(0, Integer::sum);
        int n = data.length;
        return (n*(n+1)/2)- sum;
    }
}
