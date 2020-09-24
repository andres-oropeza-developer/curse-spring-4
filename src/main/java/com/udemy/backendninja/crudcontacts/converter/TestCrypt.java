package com.udemy.backendninja.crudcontacts.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println("Password: " + bCryptPasswordEncoder.encode("user"));
    }
}
