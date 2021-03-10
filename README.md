### This is a project to study microservices. You need to launch each one of them separately.

`API :`  
Due to an in memory database, please do not forget to add content when you launch the application with Postman or
Insomnia. You can also add a method which autofill the DB at launch.
Otherwise,you'll see nothing in the front.

`Front :`  
Nothing special to say here. Front is doing the job, and I won't ask it more.

`Tunnel :`  
For more information about event sourcing in Java, check here :  
https://www.baeldung.com/cqrs-event-sourcing-java  
This is not fully implemented yet, so I recommend to not launch it and to not use it.

`API Gateway :`  
Premises of gateway is implemented it redirect calls from front to API, see here for more information :  
https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/#gateway-starter  
https://medium.com/an-idea/spring-boot-microservices-api-gateway-e9dbcd4bb754

`Circuit Breaker :`  
This project also implements some kind of circuit breaker with Resilience4J. Documentation can be found here :  
https://resilience4j.readme.io/docs/circuitbreaker

_More to be added soon ?_