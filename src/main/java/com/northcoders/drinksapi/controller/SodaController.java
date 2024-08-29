package com.northcoders.drinksapi.controller;

import com.northcoders.drinksapi.model.Coffee;
import com.northcoders.drinksapi.model.Soda;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SodaController {

    private final AtomicLong count = new AtomicLong();

    @GetMapping("/sodalover")
    public String sodaLover(){
        return "I like soda!";
    }

    @GetMapping("/soda")
    public Soda getSoda(@RequestParam(value = "name", defaultValue = "Cola") String name) {
        return new Soda(count.incrementAndGet(), name);
    }
}