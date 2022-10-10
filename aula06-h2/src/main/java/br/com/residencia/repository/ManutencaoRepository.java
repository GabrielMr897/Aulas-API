package br.com.residencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.model.Manutencao;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
    
}
