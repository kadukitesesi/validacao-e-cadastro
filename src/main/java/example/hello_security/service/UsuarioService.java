package example.hello_security.service;


import example.hello_security.model.Usuario;
import example.hello_security.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

    @Service
    public class UsuarioService {

        @Autowired
        private UsuarioRepository usuarioRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Transactional
        public Usuario salvarUsuario(Usuario usuario) {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            return usuarioRepository.save(usuario);
        }
    }
