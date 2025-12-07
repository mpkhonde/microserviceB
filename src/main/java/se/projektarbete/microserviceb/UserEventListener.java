package se.projektarbete.microserviceb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserEventListener {

    // När ett meddelande kommer till kön "user.registered"
    // körs den här metoden automatiskt.
    @RabbitListener(queues = "user.registered")
    public void handleUserRegistered(UserRegisteredEvent event) {

        // Här skulle man egentligen skicka ett mail.
        // Nu skriver vi bara ut info i loggen.
        log.info("Skulle skicka välkomstmail till {} ({})",
                event.username(), event.email());
    }
}
