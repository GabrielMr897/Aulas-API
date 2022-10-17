package br.com.residencia.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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

    private MailConfig mailConfig;


    public List<UsuarioDTO> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuarioDTO = new ArrayList<>();


        for(Usuario usuario : usuarios) {
            usuarioDTO.add(new UsuarioDTO(usuario));
        }
        return usuarioDTO;
    }

    public UsuarioDTO inserir(UsuarioInserirDTO u) {
        

        if (usuarioRepository.findByEmail(u.getEmail()) != null) {
            throw new EmailException("Email já existe na base");

        }
        Usuario usuario = new Usuario();
        usuario.setNome(u.getNome());
        usuario.setEmail(u.getEmail());
        u.setSenha(bCryptPasswordEncoder.encode(u.getSenha()));
        usuario = usuarioRepository.save(usuario);
        for (UsuarioPerfil usuarioPerfil : u.getUsuarioPerfil()) {
            usuarioPerfil.setUsuario(usuario);
            usuarioPerfil.setPerfil(perfilService.buscar(usuarioPerfil.getPerfil().getIdPerfil()));
            usuarioPerfil.setDataCriacao(LocalDate.now());
        }
        usuarioPerfilRepository.saveAll(u.getUsuarioPerfil());
        mailConfig.sendEmail(usuario.getEmail(), "Cadastro de Usuário", usuario.toString());
        return new UsuarioDTO(usuario);
    }
}
