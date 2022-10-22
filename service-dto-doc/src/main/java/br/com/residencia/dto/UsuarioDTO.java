package br.com.residencia.dto;

import br.com.residencia.model.Usuario;

public class UsuarioDTO {

    
    private Long id;
    private String nome;
    private String email;
    private String uri;

    
    public UsuarioDTO() {
    }


    public UsuarioDTO(Usuario usuario) {
        super();
        this.id = usuario.getIdUsuario();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
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


    public String getUri() {
        return uri;
    }


    public void setUri(String uri) {
        this.uri = uri;
    }


}
