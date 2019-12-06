package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorld.class)
@ContextConfiguration(classes = {FancyWriter.class, HelloWorld.class, ReguralWriter.class})

class HelloWorldTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void textHappy() throws  Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/")).andDo(
                print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(mvcResult.getResponse().getContentAsString(), "HAAS");
    }


}