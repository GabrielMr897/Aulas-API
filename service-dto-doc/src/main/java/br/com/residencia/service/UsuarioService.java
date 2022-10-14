package br.com.residencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.residencia.exception.EmailException;
import br.com.residencia.model.Usuario;
import br.com.residencia.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario inserir(Usuario u) {
        Usuario usuario = usuarioRepository.findByEmail(u.getEmail());

        if (usuario != null) {
            throw new EmailException("Email já existe na base");

        }
        u.setSenha(bCryptPasswordEncoder.encode(u.getSenha()));
        return usuarioRepository.save(u);
    }
}
