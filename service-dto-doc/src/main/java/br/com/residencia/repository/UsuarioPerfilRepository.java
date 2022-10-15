package br.com.residencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.model.UsuarioPerfil;

public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, Long> {
    
}
