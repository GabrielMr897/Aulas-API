package br.com.residencia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.residencia.dto.UsuarioDTO;
import br.com.residencia.dto.UsuarioInserirDTO;
import br.com.residencia.exception.EmailException;
import br.com.residencia.model.Usuario;
import br.com.residencia.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
        
        return new UsuarioDTO(usuario);
    }
}
