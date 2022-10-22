package br.com.residencia.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    public Endereco findByCep(String cep);
}
