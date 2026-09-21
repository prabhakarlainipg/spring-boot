package com.core.java;

@FunctionalInterface
 interface Calculator {
    int calculate(int first, int second);
}
public class Demo {

    public static void main(String[] args) {
        Calculator lambdaAddition = (first, second) -> first + second;
        System.out.println(lambdaAddition.calculate(10, 20));    // 30
    }
}