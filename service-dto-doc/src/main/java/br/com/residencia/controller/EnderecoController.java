package br.com.residencia.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.residencia.dto.EnderecoDTO;
import br.com.residencia.service.EnderecoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("{cep}") 
    @ApiOperation(value = "Buscar um cep", notes = "preencha com um cep")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Retorna o cep do cliente"),
        @ApiResponse(responseCode = "401", description = "Erro de autencicação"),
        @ApiResponse(responseCode = "403", description = "Você não tem permissão para o recurso"),
        @ApiResponse(responseCode = "404", description = "Cep não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro na aplicação")
    })
    public ResponseEntity<EnderecoDTO> buscar(@PathVariable String cep) {
            EnderecoDTO dto = enderecoService.buscar(cep);

            if(dto == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(dto);
            }
        }

    }
