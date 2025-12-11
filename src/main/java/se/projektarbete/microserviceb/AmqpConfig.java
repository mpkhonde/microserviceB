package se.projektarbete.microserviceb;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// ===============================
// Inställningar för RabbitMQ
// ===============================
@Configuration
public class AmqpConfig {

    // Namnet på kön som används när en användare registreras
    public static final String USER_REGISTERED_QUEUE = "user.registered";

    // ===============================
    // Skapar själva kön
    // ===============================
    @Bean
    public Queue userRegisteredQueue() {
        // durable = kön finns kvar även om RabbitMQ startas om
        return QueueBuilder.durable(USER_REGISTERED_QUEUE).build();
    }

    // ===============================
    // Gör så att meddelanden skickas/ tas emot som JSON
    // ===============================
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    // ===============================
    // Fabrik som lyssnar på meddelanden
    // ===============================
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
            ConnectionFactory connectionFactory,
            MessageConverter messageConverter
    ) {
        SimpleRabbitListenerContainerFactory factory =
                new SimpleRabbitListenerContainerFactory();

        // Kopplar in anslutningen till RabbitMQ
        factory.setConnectionFactory(connectionFactory);

        // Sätter att meddelanden ska omvandlas till JSON-objekt
        factory.setMessageConverter(messageConverter);

        return factory;
    }
}
