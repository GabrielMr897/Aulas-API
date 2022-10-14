package br.com.residencia.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class LancamentoVendas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;

    @Column(name ="data_venda")
    private LocalDateTime dataVenda;

    @Column(name = "valor_venda")
    private Double valorVenda;


    
}
