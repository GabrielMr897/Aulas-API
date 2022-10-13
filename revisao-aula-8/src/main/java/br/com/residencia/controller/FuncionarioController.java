package br.com.residencia.controller;

import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.residencia.model.Funcionario;
import br.com.residencia.repository.FuncionarioRepository;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario inserir(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @GetMapping
    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }
}
