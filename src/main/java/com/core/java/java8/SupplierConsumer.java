package com.core.java.java8;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
//Predicate (filtering),
// Function (transformation),
// Consumer (processing), and Supplier (value generation).

//Function<Employee, EmployeeDTO> mapper =
//        e -> new EmployeeDTO(e.getId(),
//                             e.getName());

//Predicate<Employee> isActive =
//        e -> e.isActive();
public class SupplierConsumer {
    public static void main(String[] args) {


        Predicate<Integer> isEven =
                n -> n % 2 == 0;

        System.out.println(isEven.test(10));



        Function<String,Integer> length =
                s -> s.length();

        System.out.println(length.apply("Java"));
        Consumer<String> notifier = (msg)->{System.out.println(msg);};

        Supplier<String> otpSupplier = () -> {
            return UUID.randomUUID().toString();
        };

        //THIS IS ALSO VALID WITHOUT CURLY BRACES
        // Supplier<String> otpSupplier = () ->
        //             UUID.randomUUID().toString();


        notifier.accept("Email Sent");
        System.out.println(otpSupplier.get());

    }
}
