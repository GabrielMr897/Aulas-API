package br.com.residencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.model.Foto;

public interface FotoRepository extends JpaRepository<Foto, Long> {
    
}
