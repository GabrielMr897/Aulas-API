package br.com.residencia.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.residencia.dto.UsuarioDTO;
import br.com.residencia.dto.UsuarioInserirDTO;
import br.com.residencia.model.Foto;
import br.com.residencia.service.FotoService;
import br.com.residencia.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private FotoService fotoService;


    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {
        return ResponseEntity.ok(usuarioService.listar());
    }


    @PostMapping
    public ResponseEntity<Object> inserir(@RequestParam MultipartFile file, @RequestPart UsuarioInserirDTO usuarioInserirDTO) throws IOException{

        try {

            UsuarioDTO usuarioDTO = usuarioService.inserir(usuarioInserirDTO, file);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarioDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(usuarioDTO);
            
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }

        
    }

    @GetMapping("/{id}/foto")
    public ResponseEntity<byte[]> buscarPorFoto(@PathVariable Long id) {
        Foto foto = fotoService.buscar(id);
        HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.add("Content-Type", foto.getTipo());
        httpHeaders.add("content-length",  String.valueOf(foto.getDados().length));

        return new ResponseEntity<>(foto.getDados(), httpHeaders, HttpStatus.OK);
    }
}
