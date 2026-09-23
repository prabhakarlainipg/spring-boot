package com.core.java.java8;

interface A {
    default void show() {
        System.out.println("A");
    }
}

interface B {
    default void show() {
        System.out.println("B");
    }
}
public class DiamondProblem implements A,B {

    //super - selects its inherited default implementation.
    @Override
    public void show() {
        A.super.show();
    }

    public static void main(String[] args){
        DiamondProblem d = new DiamondProblem();
        d.show();
    }
}
