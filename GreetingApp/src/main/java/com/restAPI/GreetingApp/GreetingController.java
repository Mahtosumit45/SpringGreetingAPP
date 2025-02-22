package com.restAPI.GreetingApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    // Constructor-based dependency injection
    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // GET: Returns a personalized greeting message based on query parameters
    @GetMapping
    public Map<String, String> getGreeting(@RequestParam(required = false) String firstName,
                                           @RequestParam(required = false) String lastName) {
        Map<String, String> response = new HashMap<>();
        String greetingMessage = greetingService.getGreetingMessage(firstName, lastName);
        response.put("greeting", greetingMessage);
        return response;
    }

    // POST: Accepts a new greeting message
    @PostMapping
    public Map<String, String> createGreeting(@RequestBody Map<String, String> greeting) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Greeting created: " + greeting.get("message"));
        return response;
    }

    // PUT: Updates the existing greeting message
    @PutMapping
    public Map<String, String> updateGreeting(@RequestBody Map<String, String> greeting) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Greeting updated to: " + greeting.get("message"));
        return response;
    }

    // DELETE: Deletes the current greeting message
    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Greeting deleted");
        return response;
    }
}





