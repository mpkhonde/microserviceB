package se.projektarbete.microserviceb;

// "record" används för att skapa en enkel datastruktur.
// Den lagrar bara värdena vi skickar med.
public record UserRegisteredEvent(
        Long userId,    // id på användaren
        String username, // användarnamn
        String email     // e-postadress
) {
}
