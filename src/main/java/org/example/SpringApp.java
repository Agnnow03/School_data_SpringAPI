package org.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.example.repositories")
public class SpringApp{
    public static void main(String[] args) {
        SpringApplication.run(SpringApp.class, args);

    }

}