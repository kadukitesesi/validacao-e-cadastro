package example.hello_security.service;


import example.hello_security.model.Usuario;
import example.hello_security.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

    @Service
    public class UsuarioService {

        @Autowired
        private UsuarioRepository usuarioRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        public Usuario salvarUsuario(Usuario usuario) {
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            return usuarioRepository.save(usuario);
        }

        public Usuario findByUsername(String username) {
            return usuarioRepository.findByUsername(username);
        }
    }
