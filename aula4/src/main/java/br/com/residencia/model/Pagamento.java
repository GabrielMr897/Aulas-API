package br.com.residencia.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pagamento {

    @Autowired
    private Consulta consulta;
    
    @Autowired
    private Exame exame;
    
    
    public Double calcularProcedimentos(Double valorConsulta, Double valorExame) {
        return consulta.calcularValorConsulta(valorConsulta) + exame.calcularValorExame(valorExame);
    }
}
