package br.com.residencia.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class LancamentoVendas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;

    @Column(name ="data_venda")
    private LocalDate dataVenda;

    @Column(name = "valor_venda")
    private Double valorVenda;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_vendedor")
    private VendedorAutonomo vendedorAutonomo;

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }
    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public VendedorAutonomo getVendedorAutonomo() {
        return vendedorAutonomo;
    }

    public void setVendedorAutonomo(VendedorAutonomo vendedorAutonomo) {
        this.vendedorAutonomo = vendedorAutonomo;
    }


    
}
