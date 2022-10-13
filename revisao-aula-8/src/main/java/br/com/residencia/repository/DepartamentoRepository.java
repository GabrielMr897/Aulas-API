package br.com.residencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.model.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    
}
