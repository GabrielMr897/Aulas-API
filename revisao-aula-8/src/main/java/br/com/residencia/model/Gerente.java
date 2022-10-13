package br.com.residencia.model;

import javax.persistence.Embeddable;

@Embeddable
public class Gerente{
    
    private String setor;

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
