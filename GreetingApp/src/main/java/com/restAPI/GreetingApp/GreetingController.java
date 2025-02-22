package com.restAPI.GreetingApp;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private Map<Integer, String> greetings = new HashMap<>();

    // GET: Returns a greeting message
    @GetMapping
    public Map<String, String> getGreeting() {
        greetings.put(1, "Hello from BridgeLabz!");
        Map<String, String> response = new HashMap<>();
        response.put("greeting", greetings.get(1));
        return response;
    }

    // POST: Accepts a new greeting message
    @PostMapping
    public Map<String, String> createGreeting(@RequestBody Map<String, String> greeting) {
        greetings.put(1, greeting.get("message"));
        Map<String, String> response = new HashMap<>();
        response.put("message", "Greeting created: " + greeting.get("message"));
        return response;
    }

    // PUT: Updates the existing greeting message
    @PutMapping
    public Map<String, String> updateGreeting(@RequestBody Map<String, String> greeting) {
        greetings.put(1, greeting.get("message"));
        Map<String, String> response = new HashMap<>();
        response.put("message", "Greeting updated to: " + greeting.get("message"));
        return response;
    }

    // DELETE: Deletes the existing greeting message
    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        greetings.remove(1);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Greeting deleted");
        return response;
    }
}



