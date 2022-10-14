package br.com.residencia.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.residencia.model.VendedorAutonomo;
import br.com.residencia.service.VendedorAutonomoService;


@RestController
@RequestMapping("/vendedores")
public class VendedorAutonomoController {
    @Autowired
    private VendedorAutonomoService vendedorAutonomoService;


    @GetMapping
    public ResponseEntity<List<VendedorAutonomo>> listar() {
        return ResponseEntity.ok(vendedorAutonomoService.listar());
    }


    @PostMapping
    public ResponseEntity<Object> inserir(@RequestBody VendedorAutonomo vendedorAutonomo) {

        try {

            vendedorAutonomo = vendedorAutonomoService.inserir(vendedorAutonomo);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vendedorAutonomo.getIdVendedor()).toUri();

            return ResponseEntity.created(uri).body(vendedorAutonomo);
            
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }

        
    }
}
