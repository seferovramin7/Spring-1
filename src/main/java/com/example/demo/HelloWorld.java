package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @Autowired
    @Qualifier("RegularWriter")
    TextWriter text;


    @Autowired
    @Qualifier("FancyWriter")
    TextWriter text1;

    @RequestMapping("/")
    public String index(){
        return text.writeText("hi");
    }
}
