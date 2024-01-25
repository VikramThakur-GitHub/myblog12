package com.myblog.myblog11;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestClass1 {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Mike", 35, "Ranchi"),
                new Employee("Rahul", 35, "Chennai"),
                new Employee("Sam",21, "Pune"),
                new Employee("Ram",25, "Pune"),
                new Employee("Sita", 21,"Noida")
        );

        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(e -> e.getCity()));
        Map<Integer, List<Employee>> collect1 = employees.stream().collect(Collectors.groupingBy(e -> e.getAge()));

        for(Map.Entry<Integer, List<Employee>> entry: collect1.entrySet()){

            int age = entry.getKey();
            List<Employee> employeesWithAge = entry.getValue();
            System.out.print("Employess with Age : "+age+" : ");

            for (Employee e: employeesWithAge){
                System.out.print(e.getName()+" - ");
                System.out.print(e.getCity()+ "  ,");

            }
            System.out.println();
        }

       /* for(Map.Entry<Integer, List<Employee>> entry: collect1.entrySet()){

            int age = entry.getKey();
            List<Employee> employeesWithAge = entry.getValue();
            System.out.println("Employess with Age : "+age);

            for (Employee e: employeesWithAge){
                System.out.println(e.getName()+"  ");

            }
        }*/

//        List<Employee> emps = employees.stream().filter(emp -> emp.getAge() > 30).collect(Collectors.toList());
//        List<Employee> emps = employees.stream().filter(emp -> emp.getName().startsWith("M")).collect(Collectors.toList());

        for(Employee e: employees){
            System.out.print(e.getName()+" - ");
            System.out.print(e.getAge()+" - ");
            System.out.println(e.getCity());
        }

        List<Integer> list = Arrays.asList(2,4,3,5,7,9,11,32);

        List<Integer> EvenNum = list.stream().filter(n -> n % 2 == 0).toList();
        List<Integer> squared = EvenNum.stream().map(n -> n * n).toList();
        Optional<Integer> sum = squared.stream().reduce(Integer::sum);

        for(Integer i: EvenNum){
            System.out.print(i+"  ");
        }
        System.out.println();
        for(Integer i: squared){
            System.out.print(i+"  ");
        }
        System.out.println();
        System.out.println(sum);

    }

}
