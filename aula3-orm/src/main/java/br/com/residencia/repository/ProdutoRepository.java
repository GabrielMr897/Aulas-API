package br.com.residencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.residencia.model.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
