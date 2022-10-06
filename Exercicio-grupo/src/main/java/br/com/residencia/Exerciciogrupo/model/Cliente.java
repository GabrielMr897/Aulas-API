package br.com.residencia.Exerciciogrupo.model;

import java.time.LocalDate;

public class Cliente {
    
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;

    
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
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    
    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", dataNascimento="
                + dataNascimento + "]";
    }
}
