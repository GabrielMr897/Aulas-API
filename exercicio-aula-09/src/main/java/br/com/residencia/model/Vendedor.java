package br.com.residencia.model;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@MappedSuperclass
public class Vendedor{
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vendedor")
    protected Long idVendedor;


   
    @NotBlank(message = "preencha o campo nome")
    private String nome;

    @NotBlank(message = "preencha o campo email")
    private String email;

    @NotBlank(message = "preencha o campo salario")
    private Double salario;

    @JsonManagedReference
    @OneToMany(mappedBy = "vendedorAutonomo")
    private List<LancamentoVendas> LancamentoVendas;
   

    public Long getIdVendedor() {
        return idVendedor;
    }
    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    

    
}
