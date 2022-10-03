package br.com.residencia.api.exercicio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class hello {
    @GetMapping("/hello")
    public String teste() {
        return "Hello World";
    }


    @GetMapping("/reposta")
    public String reposta() {
        return "Teste";
    }
}
