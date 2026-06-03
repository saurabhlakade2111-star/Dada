package com.example.Helloword.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Contradada {

    @GetMapping("/dada")
    public String dosomthing(){
        return "Rakhu mai rakhu mai";
    }
}
