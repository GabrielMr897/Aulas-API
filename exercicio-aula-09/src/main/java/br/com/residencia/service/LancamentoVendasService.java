package br.com.residencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.model.LancamentoVendas;

import br.com.residencia.repository.LancamentoVendasRepository;

@Service
public class LancamentoVendasService {
    @Autowired
    private LancamentoVendasRepository lancamentoVendasRepository;

    

    public List<LancamentoVendas> listar() {
        return lancamentoVendasRepository.findAll();
    }

    public LancamentoVendas inserir(LancamentoVendas l) {
        return lancamentoVendasRepository.save(l);
    }
}
