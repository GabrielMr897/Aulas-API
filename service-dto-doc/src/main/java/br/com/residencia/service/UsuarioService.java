package br.com.residencia.service;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.residencia.config.MailConfig;
import br.com.residencia.dto.UsuarioDTO;
import br.com.residencia.dto.UsuarioInserirDTO;
import br.com.residencia.exception.EmailException;
import br.com.residencia.model.Usuario;
import br.com.residencia.model.UsuarioPerfil;
import br.com.residencia.repository.UsuarioPerfilRepository;
import br.com.residencia.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private UsuarioPerfilRepository usuarioPerfilRepository;
    
    @Autowired
    private FotoService fotoService;

    @Autowired
    private MailConfig mailConfig;

    public UsuarioDTO inserirUriImagem(Usuario usuario) {
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/usuarios/{id}/foto").buildAndExpand(usuario.getIdUsuario()).toUri();

        UsuarioDTO dto = new UsuarioDTO();
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setUri(uri.toString());

        return dto;
    }



    public List<UsuarioDTO> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuarioDTO = new ArrayList<>();


        for(Usuario usuario : usuarios) {
            usuarioDTO.add(inserirUriImagem(usuario));
        }
        return usuarioDTO;
    }

    public UsuarioDTO inserir(UsuarioInserirDTO usuarioInserirDTO, MultipartFile file) throws IOException{

        if (usuarioRepository.findByEmail(usuarioInserirDTO.getEmail()) != null) {
            throw new EmailException("Email já existe na base");

        }
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioInserirDTO.getNome());
        usuario.setEmail(usuarioInserirDTO.getEmail());
        usuario.setSenha(bCryptPasswordEncoder.encode(usuarioInserirDTO.getSenha()));
        fotoService.inserir(usuarioRepository.save(usuario), file);
        //usuario = usuarioRepository.save(usuario);
        for (UsuarioPerfil usuarioPerfil : usuarioInserirDTO.getUsuarioPerfil()) {
            usuarioPerfil.setUsuario(usuario);
            usuarioPerfil.setPerfil(perfilService.buscar(usuarioPerfil.getPerfil().getIdPerfil()));
            usuarioPerfil.setDataCriacao(LocalDate.now());
        }
        usuarioPerfilRepository.saveAll(usuarioInserirDTO.getUsuarioPerfil());
        //mailConfig.sendEmail(usuario.getEmail(), "Cadastro de Usuário", usuario.toString());
        return inserirUriImagem(usuario);
    }
}
