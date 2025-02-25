package com.restAPI.GreetingApp;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.*;
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
    public Greeting getGreetingById(Long id) {
        return greetings.get(id);
    }
    public List<Greeting> getAllGreetings() {
        return new ArrayList<>(greetings.values());
    }
    public Greeting updateGreeting(Long id, String firstName, String lastName) {
        if (greetings.containsKey(id)) {
            String message = getGreetingMessage(firstName, lastName);
            Greeting updatedGreeting = new Greeting(id, message);
            greetings.put(id, updatedGreeting);
            return updatedGreeting;
        }
        return null;
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