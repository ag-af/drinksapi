package com.northcoders.drinksapi.model;

public class Coffee {
    Long id;
    String name;

    public Coffee(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
