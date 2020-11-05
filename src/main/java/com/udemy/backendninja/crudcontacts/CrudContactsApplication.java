package com.udemy.backendninja.crudcontacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CrudContactsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudContactsApplication.class, args);
    }

}
