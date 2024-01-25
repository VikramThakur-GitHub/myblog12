package com.myblog.myblog11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/*
import java.lang.reflect.Array;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
*/

public class TestClass {
    public static void main(String[] args) {

        List<Login> logins = Arrays.asList(
                new Login("mike", "testing"),
                new Login("Ram", "testing"),
                new Login("Sita", "testing")
        );

        List<LoginDto> dtos = logins.stream().map(login -> mapToDto(login)).collect(Collectors.toList());
        System.out.println(dtos);
    }
        static LoginDto mapToDto(Login login){
            LoginDto dto = new LoginDto();
            dto.setUsername(login.getUsername());
            dto.setPassword(login.getPassword());

            return dto;






/*        // PREDICATE<T> Functional Interface

        Predicate<Integer> val = x-> x%2==0;
        boolean test = val.test(10);
        System.out.println(test);

        Predicate<String> val = s->s.equals("mike");
        boolean test1 = val.test("mike");
        System.out.println(test1);

        List<Integer> list = Arrays.asList(12, 3, 5, 6, 17, 15);
        List<Integer> evenNum = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNum);

        List<Integer> list = Arrays.asList(12, 3, 5, 6, 17, 15);
        List<Integer> oddNum = list.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
        System.out.println(oddNum);

        List<String> list = Arrays.asList("mike", "stalin", "hero", "mike");
        List<String> data1 = list.stream().filter(s -> s.startsWith("m")).collect(Collectors.toList());

        List<String> data2 = list.stream().filter(s -> s.equals("mike")).collect(Collectors.toList());

        List<String> data3 = list.stream().filter(s -> s.endsWith("n")).collect(Collectors.toList());
        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);

        //FUNCTION<T,R> Functional Interface
        // FUNCTION<T,R> Functional Interface , takes an input T and generates an output R.

        Function<String,Integer> result = str-> str.length();
        Integer val = result.apply("Vikram");
        System.out.println(val);

        Function<Integer,Integer> result = str-> str + 10;
        Integer val = result.apply(25);
        System.out.println(val);

        List<Integer> list= Arrays.asList(12,13,4,2,5,7,9);
        List<Integer> evenNum = list.stream().map(i -> i +10).collect(Collectors.toList());
        System.out.println(evenNum);

        List<String> list= Arrays.asList("mike", "Deep", "Vikram", "Riya");
        List<String> name = list.stream().map(i -> i.toLowerCase()).collect(Collectors.toList());
        System.out.println(name);

        List<String> list= Arrays.asList("Mike", "Deep", "Vikram", "Riya");
        List<String> name = list.stream().sorted().collect(Collectors.toList());
        System.out.println(name);

        List<Integer> list= Arrays.asList(12,13,4,2,5,7,9);
        List<Integer> sort = list.stream().sorted().collect(Collectors.toList());
        System.out.println(sort);

        List<Integer> list= Arrays.asList(12,13,4,2,4,5,5,5,2,5,7,9);
        List<Integer> uniqueNum = list.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueNum);

        //CONSUMER<T> Functional Interface (takes input and produces no output).

         Consumer<Integer> val = num-> System.out.println(num);
        val.accept(100);

        List<String> list = Arrays.asList("mike", "Bholu", "Ram");
        Consumer<String> val = name-> System.out.println(name);
        list.forEach(val);

        //SUPPLIER<T> Functional Interface

        Supplier<Integer> x =()-> new Random().nextInt(100);
        Integer y = x.get();
        System.out.println(y);*/



    }
}
