package br.com.residencia.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_perfil")
    private Long idPerfil;
    private String nome;

    @OneToMany(mappedBy = "id.perfil", fetch = FetchType.EAGER)
    private Set<UsuarioPerfil> usuarioPerfil = new HashSet<>();

    public Long getIdPerfil() {
        return idPerfil;
    }
    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Set<UsuarioPerfil> getUsuarioPerfil() {
        return usuarioPerfil;
    }
    public void setUsuarioPerfil(Set<UsuarioPerfil> usuarioPerfil) {
        this.usuarioPerfil = usuarioPerfil;
    }

}
