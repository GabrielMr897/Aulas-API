package br.com.residencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.residencia.dto.EnderecoDTO;
import br.com.residencia.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("{cep}") 
        public ResponseEntity<EnderecoDTO> buscar(@PathVariable String cep) {
            EnderecoDTO dto = enderecoService.buscar(cep);

            if(dto == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(dto);
            }
        }

    }
