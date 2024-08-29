package com.northcoders.drinksapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class SodaControllerTests {

    @Autowired
    private MockMvc mockMvcController;

    @Test
    public void testGetSodaLover() throws Exception {

        String expectedContent = "I like soda!";

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/sodalover"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testGetCoffeeDefault() throws Exception {

        String expectedValue = "Cola";

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/soda"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedValue));
    }

    @Test
    public void testGetCoffeeCap() throws Exception {

        String expectedValue = "Cappuccino";

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffee").param("name", "Cappuccino"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedValue));
    }
}