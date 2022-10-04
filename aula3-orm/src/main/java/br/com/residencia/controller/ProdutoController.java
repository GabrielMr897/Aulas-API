package br.com.residencia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.residencia.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private ProdutoRepository produtoRepository;
}
