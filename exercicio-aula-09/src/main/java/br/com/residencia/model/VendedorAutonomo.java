package br.com.residencia.model;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class VendedorAutonomo extends Vendedor {
    
    @JsonManagedReference
    @OneToMany(mappedBy = "vendedorAutonomo")
    private List<LancamentoVendas> LancamentoVendas;

    private Double comissao;

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }
}
