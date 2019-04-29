package com.atm.demo;

import com.atm.demo.dao.Dao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        Dao.createAccounts();
    }
}
