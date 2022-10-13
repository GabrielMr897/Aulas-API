package br.com.residencia.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.residencia.model.Departamento;
import br.com.residencia.repository.DepartamentoRepository;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Departamento inserir(@RequestBody Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @GetMapping
    public List<Departamento> listar() {
        return departamentoRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Departamento> buscar(@PathVariable Long id) {
        Optional<Departamento> departamento = departamentoRepository.findById(id);

        
        if (departamento.isPresent()) {
			return ResponseEntity.ok(departamento.get());
		}
		return ResponseEntity.notFound().build();
	}
}
