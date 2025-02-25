package com.restAPI.GreetingApp;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GreetingService {
    private final Map<Long, Greeting> greetings = new HashMap<>();
    private Long counter = 1L;

    public Greeting saveGreeting(String firstName, String lastName) {
        String message = getGreetingMessage(firstName, lastName);
        Greeting greeting = new Greeting(counter++, message);
        greetings.put(greeting.getId(), greeting);
        return greeting;
    }

    private String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName;
        } else if (firstName != null) {
            return "Hello " + firstName;
        } else if (lastName != null) {
            return "Hello " + lastName;
        } else {
            return "Hello World";
        }
    }
}