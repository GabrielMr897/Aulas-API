package br.com.residencia.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.model.LancamentoVendas;

public interface LancamentoVendasRepository extends JpaRepository<LancamentoVendas, Long> {
    
}
