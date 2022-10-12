package br.com.residencia.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Departamento extends Funcionario {

    @Id
    @Column(name = "id_departamento")
    private Long id;

    @JsonManagedReference
    @OneToMany(mappedBy = "departamento")
    private List<Funcionario> funcionario;
}
