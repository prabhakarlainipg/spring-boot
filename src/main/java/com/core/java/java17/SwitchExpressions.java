package com.core.java.java17;

public class SwitchExpressions {
    public static void main(String[] args) {
        String day = "MONDAY";

        String category = switch (day) {
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"
                    -> "Weekday";
            case "SATURDAY", "SUNDAY"
                    -> "Weekend";
            default -> "Invalid day";
        };

        System.out.println(category); // Weekday
    }
}
