package br.com.residencia.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.residencia.model.Manutencao;
import br.com.residencia.repository.ManutencaoRepository;


@RestController
@RequestMapping("/manutencoes")
public class ManutencaoController {
    @Autowired
    private ManutencaoRepository  manutencaoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Manutencao inserir(@Valid @RequestBody Manutencao manutencao) {
        return manutencaoRepository.save(manutencao);
    }


    @GetMapping
    public List<Manutencao> listar() {
        return manutencaoRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Manutencao> buscar(@PathVariable Long id) {
        Optional<Manutencao> manutencao = manutencaoRepository.findById(id);

        
        if (manutencao.isPresent()) {
			return ResponseEntity.ok(manutencao.get());
		}
		return ResponseEntity.notFound().build();
	}




}

    

