package com.core.java.java17;

public class TextBlocks {
    public static void main(String[] args) {
        String first = """
        Java
        """;

        String second = """
        Java""";

        System.out.println(first.equals("Java\n")); // true
        System.out.println(second.equals("Java"));  // true

        String name = "Alice";

        String message = """
        Hello, %s!
        Welcome to Java.
        """.formatted(name);

        System.out.println(message);
    }
}
