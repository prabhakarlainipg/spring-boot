package com.core.java.java8;

import com.core.java.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MethodReferences {
    public static void main(String[] args) {
        Employee e1 = createEmployee(1, "Alice", 50000, "Pune", "IT");
        Employee e2 = createEmployee(2, "Bob", 60000, "Mumbai", "HR");
        Employee e3 = createEmployee(3, "Charlie", 70000, "Delhi", "Finance");
        Employee e4 = createEmployee(4, "Diana", 80000, "Chennai", "IT");
        Employee e5 = createEmployee(5, "Eve", 55000, "Bangalore", "Sales");


        List<Employee> employeeList = new ArrayList<>(List.of(e1, e2, e3, e4, e5));
        employeeList.sort(Comparator.comparing(Employee::getCity));
        employeeList.stream().map(Employee::getCity).forEach(System.out::println);


    }

    static Employee createEmployee(int id, String name, int salary, String city, String dept) {
        Employee e = new Employee();
        e.setId(id);
        e.setName(name);
        e.setSalary(salary);
        e.setCity(city);
        e.setDept(dept);
        return e;
    }
}
