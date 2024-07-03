package example.hello_security.config;

import example.hello_security.model.Usuario;
import example.hello_security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService  implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);

        if(usuario == null) {
            throw new UsernameNotFoundException("User Not found");
        }
        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles("USER")
                .build();
    }
}
