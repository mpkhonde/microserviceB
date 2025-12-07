package se.projektarbete.microserviceb;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfig {

    // Namnet på kön vi använder när en användare skapas
    public static final String USER_REGISTERED_QUEUE = "user.registered";


    // Här gör vi själva kön.
    // "durable" betyder att kön finns kvar om RabbitMQ startas om.
    @Bean
    public Queue userRegisteredQueue() {

        return QueueBuilder
                .durable(USER_REGISTERED_QUEUE)
                .build();
    }
}
