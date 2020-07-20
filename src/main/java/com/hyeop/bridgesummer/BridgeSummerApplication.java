package com.hyeop.bridgesummer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BridgeSummerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BridgeSummerApplication.class, args);
    }

}
