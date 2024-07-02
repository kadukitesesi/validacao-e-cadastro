package example.hello_security.controller;


import example.hello_security.model.Usuario;
import example.hello_security.service.UsuarioService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerUsuario {

    List<String> usuarios = new ArrayList<String>();

    @Autowired
    private UsuarioService usuarioService;

    @PostConstruct
    public void init() {
        setUsuarios();
    }

    public List<String> setUsuarios() {
        usuarios.add("pedrin");
        usuarios.add("carlin");
        return usuarios;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<String>> getUsers() {

        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/login")
        String login() {
            return "login";
    }

    @GetMapping("/novo")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro_form";
    }

    @PostMapping("/novo")
    public String cadastrarUsuario(Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        return "redirect:/usuarios";
    }
}
