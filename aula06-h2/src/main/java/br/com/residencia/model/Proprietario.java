package br.com.residencia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Proprietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proprietario")
    private Long idProprietario;

    @NotBlank(message = "Preencha o campo nome")
    private String nome;




    public Long getIdProprietario() {
        return idProprietario;
    }
    public void setIdProprietario(Long idProprietario) {
        this.idProprietario = idProprietario;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "Proprietario [idProprietario=" + idProprietario + ", nome=" + nome + "]";
    }
}
