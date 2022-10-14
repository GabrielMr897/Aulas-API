package br.com.residencia.model;

import javax.persistence.Entity;

@Entity
public class VendedorAutonomo extends Vendedor {
    
    private Double comissao;

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }
}
