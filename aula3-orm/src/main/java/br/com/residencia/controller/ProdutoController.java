package br.com.residencia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.residencia.model.Produto;
import br.com.residencia.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> buscar(@PathVariable Long id) {
      Optional<Produto> produto = produtoRepository.findById(id);
      if(produto.isPresent()) {
        return ResponseEntity.ok(produto.get());
      }

      return ResponseEntity.notFound().build();
    }
}
