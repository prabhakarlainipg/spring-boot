package com.core.java.java17;

//Java automatically provides:
//- A constructor accepting all three components.
//- Accessors: id(), name(), and department().
//- equals() and hashCode() based on the components.
//- A readable toString().
//Record component fields are final, and there are no generated setters:
 record Employee(int id, String name, String department) {
}
public class Records {
    public static void main(String[] args) {
        Employee first = new Employee(101, "Alice", "IT");
        Employee second = new Employee(101, "Alice", "IT");

        System.out.println(first.name());         // Alice
        System.out.println(first.equals(second)); // true
        System.out.println(first == second);      // false
        System.out.println(first);
// Employee[id=101, name=Alice, department=IT]
    }

}
