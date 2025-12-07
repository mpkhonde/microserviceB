package se.projektarbete.microserviceb;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Slår på stöd för RabbitMQ
@EnableRabbit

// Säger att det här är ett Spring Boot-projekt
@SpringBootApplication
public class MicroserviceBApplication {

    // Här börjar programmet
    public static void main(String[] args) {

        // Startar hela appen
        SpringApplication.run(MicroserviceBApplication.class, args);
    }
}
