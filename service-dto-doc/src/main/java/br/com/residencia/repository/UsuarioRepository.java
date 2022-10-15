package br.com.residencia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
    Optional<Usuario>  findByNome(String nome);
}
