package br.com.residencia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Long idMedico;

    private String crm;

    private String nome;


    @ManyToOne
    @JoinColumn(name = "id_especialidade")
    private Especialidade especialidade;


    public Long getIdMedico() {
        return idMedico;
    }


    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }


    public String getCrm() {
        return crm;
    }


    public void setCrm(String crm) {
        this.crm = crm;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public Especialidade getEspecialidade() {
        return especialidade;
    }


    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}
