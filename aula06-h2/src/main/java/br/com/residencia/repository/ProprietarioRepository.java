package br.com.residencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.model.Proprietario;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Long>{
    
}
