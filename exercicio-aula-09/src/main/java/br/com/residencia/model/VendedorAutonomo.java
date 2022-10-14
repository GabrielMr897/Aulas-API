package br.com.residencia.model;



import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;


@Entity
public class VendedorAutonomo extends Vendedor {
    
    
    @NotBlank(message = "preencha o campo de comissão corretamente")
    private Double comissao;

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }
}
