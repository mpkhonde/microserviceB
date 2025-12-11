package se.projektarbete.microserviceb.email;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

// ===============================
// Klass som skickar mail
// ===============================
@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    // Verktyg för att skicka mail
    private final JavaMailSender mailSender;

    // Adressen mailet skickas från
    @Value("${spring.mail.from:no-reply@local}")
    private String from;

    // ===============================
    // Metod som skickar välkomstmail
    // ===============================
    public void sendRegistrationEmail(String to, String username) {
        try {
            // Skapar ett nytt mail
            SimpleMailMessage message = new SimpleMailMessage();

            // Sätter avsändare
            message.setFrom(from);

            // Sätter mottagare
            message.setTo(to);

            // Sätter ämne i mailet
            message.setSubject("Välkommen!");

            // Texten som skickas i mailet
            message.setText(
                    "Hej " + username + "!\n\n" +
                            "Ditt konto har nu skapats. En admin kommer att aktivera det snart.\n\n" +
                            "Hälsningar"
            );

            // Skickar mailet
            mailSender.send(message);

            // Skriver i loggen att det fungerade
            log.info("Mail skickat till {}", to);

        } catch (Exception e) {
            // Skriver i loggen om det blev fel
            log.error("Kunde inte skicka mail till {}: {}", to, e.getMessage());
        }
    }
}
