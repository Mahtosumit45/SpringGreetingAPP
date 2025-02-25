package com.restAPI.GreetingApp;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @PostMapping
    public Greeting saveGreeting(@RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String lastName) {
        return greetingService.saveGreeting(firstName, lastName);
    }
    @GetMapping("/{id}")
    public Greeting getGreeting(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }
    @GetMapping
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
    @PutMapping("/{id}")
    public Greeting updateGreeting(@PathVariable Long id,
                                   @RequestParam(required = false) String firstName,
                                   @RequestParam(required = false) String lastName) {
        return greetingService.updateGreeting(id, firstName, lastName);
    }
    @DeleteMapping("/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        return greetingService.deleteGreeting(id) ? "Greeting deleted" : "Greeting not found";
    }
}