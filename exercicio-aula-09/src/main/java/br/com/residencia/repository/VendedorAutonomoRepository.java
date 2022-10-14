package br.com.residencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.model.VendedorAutonomo;

public interface VendedorAutonomoRepository extends JpaRepository<VendedorAutonomo, Long> {
    VendedorAutonomo findByEmail(String email);
}
