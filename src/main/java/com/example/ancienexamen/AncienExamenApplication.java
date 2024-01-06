package com.example.ancienexamen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class AncienExamenApplication {

    public static void main(String[] args) {
        SpringApplication.run(AncienExamenApplication.class, args);
    }

}
