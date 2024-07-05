package example.hello_security.repository;

import example.hello_security.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{


    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findById(UUID id);
}
