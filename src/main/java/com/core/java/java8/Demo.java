package com.core.java.java8;

@FunctionalInterface
 interface Calculator {
    int calculate(int first, int second);
}
public class Demo {

    public static void main(String[] args) {
        Calculator lambdaAddition = Integer::sum;
        System.out.println(lambdaAddition.calculate(10, 20));    // 30
        Calculator lambdaMultiply = (first, second) -> first * second;
        System.out.println(lambdaMultiply.calculate(10, 20));
        Calculator lambdaMax = Math::max;
        System.out.println(lambdaMax.calculate(10, 20));
    }
}