package com.core.java.java8;

import com.core.java.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.core.java.java8.MethodReferences.createEmployee;
import static java.util.stream.Collectors.*;

public class GroupByDemo {
    public static void main(String[] args) {
        Employee e1 = createEmployee(1, "Alice", 50000, "Pune", "IT");
        Employee e2 = createEmployee(2, "Bob", 60000, "Mumbai", "HR");
        Employee e3 = createEmployee(3, "Charlie", 70000, "Delhi", "Finance");
        Employee e4 = createEmployee(4, "Diana", 80000, "Chennai", "IT");
        Employee e5 = createEmployee(5, "Eve", 80000, "Bangalore", "Sales");


        List<Employee> employeeList = List.of(e1, e2, e3, e4, e5);
        //employeeList.add(e3); //UnsupportedOperationException

        //GroupByDepartment
        Map<String, List<Employee>> groupByDept =
                employeeList.stream().collect(groupingBy(Employee::getDept));
        System.out.println(groupByDept);

        //count per Department
        Map<String, Long> countPerDept =
                employeeList.stream().collect(groupingBy(Employee::getDept, counting()));
        System.out.println(countPerDept);

        //total salary per department
        Map<String, Integer> totalSalaryPerDept =
                employeeList.stream().collect(groupingBy(Employee::getDept, summingInt(Employee::getSalary)));
        System.out.println(totalSalaryPerDept);

        //names per Department
        Map<String, List<String>> namesPerDept =
                employeeList.stream().collect(groupingBy(Employee::getDept, mapping(Employee::getName, toList())));
        System.out.println(namesPerDept);


        //get First Employee
        Employee firstEmployee = employeeList.getFirst();
        System.out.println(firstEmployee);

        // boolean anyITEmployee = employeeList.stream().anyMatch(e-> e.getDept().equals("IT"));
        boolean anyITEmployee = employeeList.stream().map(Employee::getDept).anyMatch("IT"::equals);

        System.out.println(anyITEmployee);

        //are All Employees Salary Greater than 10000
        boolean allEmployeesSalaryGreaterThanX = employeeList.stream()
                .map(Employee::getSalary).allMatch(n->n>50000);
        System.out.println(allEmployeesSalaryGreaterThanX);

        //Find Second Highest Salary Employee
        int secondHighestSalary = employeeList.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().orElseThrow();
        Employee secondHighestSalaryEmployee = employeeList.stream()
                .filter(e -> e.getSalary() == secondHighestSalary)
                .findFirst().orElseThrow();
        System.out.println(secondHighestSalaryEmployee);




        String str = "swiss";

        Character firstNonRepeatedCharacter = str.chars().mapToObj(c->(char)c)
                .collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);
        System.out.println(firstNonRepeatedCharacter);

        //String Length Greater than 5
        List<String> names =
                List.of("John","Alexander","Tom");
        List<String> lengthGreaterThan5 = names.stream().filter(s->s.length()>5).toList();
        System.out.println(lengthGreaterThan5);

        //convert list to uppercase
        List<String> uppercaseList = names.stream().map(String::toUpperCase).toList();
        System.out.println(uppercaseList);

        //Join Strings

        String joinedString = names.stream().collect(joining(","));
        System.out.println(joinedString);


        //highest salary employee
        Employee emp = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);
        System.out.println(emp);

        //highest salary employee per department
         Map<String, Optional<Employee>> highestSalEmpPerDept = employeeList.stream().collect(groupingBy(Employee::getDept,
                 maxBy(Comparator.comparing(Employee::getSalary))));
         System.out.println(highestSalEmpPerDept);

         // average salary employee per department
        Map<String, Double> avgSalPerDept = employeeList.stream().collect(groupingBy(Employee::getDept, averagingDouble(Employee::getSalary)));
        System.out.println(avgSalPerDept);

        //partition list
        Map<Boolean, List<Employee>> partitionBySalary =
                employeeList.stream()
                        .collect(
                                Collectors.partitioningBy(
                                        e -> e.getSalary() > 60000
                                )
                        );
        System.out.println(partitionBySalary);

        List<List<String>> list = List.of(
                List.of("A","B"),
                List.of("C","D")
        );

        //flatten nested lists
        List<String> flatMap = list.stream().flatMap(Collection::stream).toList();
        System.out.println(flatMap);




    }
}
