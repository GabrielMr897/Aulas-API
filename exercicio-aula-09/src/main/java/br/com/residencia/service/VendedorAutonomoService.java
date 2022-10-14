package br.com.residencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.exception.EmailException;
import br.com.residencia.model.VendedorAutonomo;
import br.com.residencia.repository.VendedorAutonomoRepository;

@Service
public class VendedorAutonomoService {
    @Autowired
    private VendedorAutonomoRepository vendedorAutonomoRepository;

    

    public List<VendedorAutonomo> listar() {
        return vendedorAutonomoRepository.findAll();
    }

    public VendedorAutonomo inserir(VendedorAutonomo v) {
        VendedorAutonomo vendedorAutonomo = vendedorAutonomoRepository.findByEmail(v.getEmail());

        if (vendedorAutonomo != null) {
            throw new EmailException("Email já existe na base");

        }
        return vendedorAutonomoRepository.save(v);
    }
}
