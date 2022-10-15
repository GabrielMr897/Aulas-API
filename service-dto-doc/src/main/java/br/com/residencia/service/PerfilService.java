package br.com.residencia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.model.Perfil;
import br.com.residencia.repository.PerfilRepository;

@Service
public class PerfilService {
    @Autowired
    private PerfilRepository perfilRepository;

    public Perfil buscar(Long id) {
        Optional<Perfil> perfil = perfilRepository.findById(id);
        return perfil.get();
    }
}
