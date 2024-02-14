package com.myblog.myblog11;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass3 {
    public static void main(String[] args) {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encoded = passwordEncoder.encode("TestingEncoder");
        System.out.println(encoded);

  /*      List<Integer> data = Arrays.asList(10, 2,2,4,6,8,10, 30, 49, 4, 6, 9, 8, 13);
        List<Integer> val = data.stream().distinct().collect(Collectors.toList());
        System.out.println(val);*/
    }
}
