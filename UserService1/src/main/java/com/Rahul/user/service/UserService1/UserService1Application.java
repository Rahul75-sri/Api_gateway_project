package com.Rahul.user.service.UserService1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.Rahul.user.service.UserService1.entities")
@EnableJpaRepositories("com.Rahul.user.service.UserService1.repositories")
public class UserService1Application {

    public static void main(String[] args) {
        SpringApplication.run(UserService1Application.class, args);
    }
}