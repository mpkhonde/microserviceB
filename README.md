Microservice B – lyssnar på nya användare

Microservice B är ett eget litet program som använder Spring Boot.
Det lyssnar på meddelanden i RabbitMQ.
När huvudsystemet registrerar en ny användare skickas ett meddelande hit.

Tjänsten tar emot ett UserRegisteredEvent från kön user.registered och skriver i loggen vilken användare som registrerats.

Vad tjänsten gör

Är en egen mikrotjänst.

Tar emot meddelanden när en ny användare skapas.

Får info om:

userId

username

email

Teknik

Java 17

Spring Boot

Spring AMQP (för RabbitMQ)

Lombok

Kan köras i en egen Docker-container

Koppling till huvudsystemet

När huvudsystemet registrerar en ny användare:

skapas ett UserRegisteredEvent

skickas till kön user.registered i RabbitMQ

