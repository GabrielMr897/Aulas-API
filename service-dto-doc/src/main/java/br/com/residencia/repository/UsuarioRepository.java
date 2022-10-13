package br.com.residencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
