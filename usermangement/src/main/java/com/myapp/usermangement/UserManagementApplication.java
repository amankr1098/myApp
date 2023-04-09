package com.myapp.usermangement;

import org.mapstruct.MapperConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.myapp.db.repository"})
@EntityScan(basePackages = {"com.myapp.db.entity"})
@SpringBootApplication(scanBasePackages = {
        "com.myapp.common",
        "com.myapp.db",
        "com.myapp.usermangement"})
public class UserManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }

}
