package se.projektarbete.microserviceb;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import se.projektarbete.microserviceb.email.EmailService;
import se.projektarbete.microserviceb.events.UserRegisteredEvent;

// ===============================
// Lyssnar på meddelanden från RabbitMQ
// ===============================
@Component
@RequiredArgsConstructor
@Slf4j
public class UserEventListener {

    // Används för att skicka mail
    private final EmailService emailService;

    // ===============================
    // Körs när något skickar ett UserRegisteredEvent
    // ===============================
    @RabbitListener(queues = "user.registered")
    public void handleUserRegistered(UserRegisteredEvent event) {

        // Skriver ut i loggen vad som kom
        log.info("Fick ett UserRegisteredEvent: {}", event);

        // Skickar ett välkomstmail till den nya användaren
        emailService.sendRegistrationEmail(event.email(), event.username());
    }
}
