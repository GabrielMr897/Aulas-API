package br.com.residencia.model;

import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Fornecedor {

    private String rg;
    private String orgaoExpedidor;
    private String cpf;


    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }
    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
