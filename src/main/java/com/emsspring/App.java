package com.emsspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@EnableJpaAuditing
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
