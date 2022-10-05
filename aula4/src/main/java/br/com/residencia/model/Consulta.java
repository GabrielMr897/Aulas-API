package br.com.residencia.model;

import org.springframework.stereotype.Component;

@Component
public class Consulta {
    public Double calcularValorConsulta(Double valor) {        
         return valor = valor * 1.10;     
    
    } 
}
