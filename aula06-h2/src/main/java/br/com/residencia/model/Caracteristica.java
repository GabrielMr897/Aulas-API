package br.com.residencia.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.residencia.enums.Categoria;
import br.com.residencia.enums.Combustivel;


@Embeddable
public class Caracteristica {
    private String renavam;
    private String chassi;
    private Integer ano;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Enumerated(EnumType.ORDINAL)
    private Combustivel Combustivel;
    
    public String getRenavam() {
        return renavam;
    }
    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }
    public String getChassi() {
        return chassi;
    }
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Combustivel getCombustivel() {
        return Combustivel;
    }
    public void setCombustivel(Combustivel combustivel) {
        Combustivel = combustivel;
    }
}
