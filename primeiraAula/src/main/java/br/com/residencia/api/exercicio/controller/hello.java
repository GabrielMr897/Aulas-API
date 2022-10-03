package br.com.residencia.api.exercicio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
    @RequestMapping("/")
    public String teste() {
        return "Hello World";
    }
}
