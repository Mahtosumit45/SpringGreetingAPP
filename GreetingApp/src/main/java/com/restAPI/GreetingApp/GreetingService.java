package com.restAPI.GreetingApp;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    // Method to return a simple greeting message
    public String getGreetingMessage() {
        return "Hello World";
    }
}

