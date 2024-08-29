package com.northcoders.drinksapi.controller;

import com.northcoders.drinksapi.model.Coffee;
import com.northcoders.drinksapi.model.Tea;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TeaController {

    private final AtomicLong count = new AtomicLong();

    @GetMapping("/tealover")
    public String teaLover(){
        return "I like tea!";
    }

    @GetMapping("/tea")
    public Tea getTea(@RequestParam(value = "name", defaultValue = "English Breakfast") String name) {
        return new Tea(count.incrementAndGet(), name);
    }
    @GetMapping("/tea/coffee")
    public ResponseEntity getTeaCoffee() {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("No Coffee here!");
    }


}
