package ru.nikishechkin.sciencebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MainService {

    public static void main(String[] args) {
        SpringApplication.run(MainService.class, args);
    }

}
