package br.com.residencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    
}
