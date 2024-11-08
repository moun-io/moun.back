package io.moun.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MounApplication {

    public static void main(String[] args) {
        SpringApplication.run(MounApplication.class, args);
    }

}
