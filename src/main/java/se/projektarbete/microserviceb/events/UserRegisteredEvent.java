package se.projektarbete.microserviceb.events;

// ===============================
// Event som skickas när en ny användare registreras
// ===============================

/*
 * Den här klassen håller bara informationen om
 * användaren som precis har registrerat sig.
 * Den skickas vidare till en annan del av systemet.
 *
 * "record" betyder att Java skapar allt åt oss,
 * som getters och konstruktor.
 */
public record UserRegisteredEvent(
        Long userId,     // id på användaren
        String username, // användarens namn
        String email     // användarens mail
) {}
