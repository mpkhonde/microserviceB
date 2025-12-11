package se.projektarbete.microserviceb;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// ===============================
// Slår på stöd för RabbitMQ
// ===============================
@EnableRabbit

// ===============================
// Visar att detta är en Spring Boot-app
// ===============================
@SpringBootApplication
public class MicroserviceBApplication {

    // ===============================
    // Programmet startar här
    // ===============================
    public static void main(String[] args) {

        // Startar hela programmet
        SpringApplication.run(MicroserviceBApplication.class, args);
    }
}
