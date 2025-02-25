package com.restAPI.GreetingApp;
import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Service
public class GreetingService {
    @Autowired
    private GreetingRepository greetingRepository;

    public Greeting saveGreeting(String firstName, String lastName) {
        String message = getGreetingMessage(firstName, lastName);
        Greeting greeting = new Greeting(null, message);
        return greetingRepository.save(greeting);
    }

    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id).orElse(null);
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Greeting updateGreeting(Long id, String firstName, String lastName) {
        if (greetingRepository.existsById(id)) {
            String message = getGreetingMessage(firstName, lastName);
            Greeting updatedGreeting = new Greeting(id, message);
            return greetingRepository.save(updatedGreeting);
        }
        return null;
    }

    public boolean deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return true;
        }
        return false;
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