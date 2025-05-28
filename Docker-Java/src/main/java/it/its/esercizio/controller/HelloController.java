package it.its.esercizio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {

    @GetMapping("/greetings")
    public String hello (@RequestParam(value = "name", defaultValue = "World")String name) {
        return "hello," + name + "!";
    }

}
