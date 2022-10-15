package br.com.residencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    
}
