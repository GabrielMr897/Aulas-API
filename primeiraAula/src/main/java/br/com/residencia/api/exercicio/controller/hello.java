package br.com.residencia.api.exercicio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class hello {
    @GetMapping("/hello")
    public String teste() {
        return "Hello World";
    }


    @GetMapping("/resposta")
    public String reposta() {
        return "Teste";
    }

    @GetMapping("/converter")
    public String converter(@RequestParam String nome) {
        return nome.toUpperCase();
    }

    @GetMapping("/soma")
    public Double somar(@RequestParam Double num1, @RequestParam Double num2) {
        return num1 + num2;
    }

}
