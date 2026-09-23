package com.core.java.java8;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

//Base64 is an encoding format, not encryption.
public class Base64Demo {

    public static void main(String[] args) {
        String original = "Java";

        String encoded = Base64.getEncoder().encodeToString(original.getBytes(StandardCharsets.UTF_8));
        System.out.println(encoded);

        String decoded = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
        System.out.println(decoded);

    }
}
