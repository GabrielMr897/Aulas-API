package br.com.residencia.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.residencia.model.LancamentoVendas;
import br.com.residencia.service.LancamentoVendasService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoVendasController {
    @Autowired
    private LancamentoVendasService lancamentoVendasService;


    @GetMapping
    public ResponseEntity<List<LancamentoVendas>> listar() {
        return ResponseEntity.ok(lancamentoVendasService.listar());
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> inserir(@Valid @RequestBody LancamentoVendas lancamentoVendas) {

        try {

            lancamentoVendas = lancamentoVendasService.inserir(lancamentoVendas);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(lancamentoVendas.getIdVenda()).toUri();

            return ResponseEntity.created(uri).body(lancamentoVendas);
            
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }

        
    }
}
