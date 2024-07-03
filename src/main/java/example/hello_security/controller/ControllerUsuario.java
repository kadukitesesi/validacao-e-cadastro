package example.hello_security.controller;

import example.hello_security.model.Usuario;
import example.hello_security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerUsuario {

    private List<String> usuarios = new ArrayList<>();

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<String>> getUsers() {
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/novo")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro_form";
    }

    @PostMapping("/novo")
    public String cadastrarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        return "redirect:/login";
    }
}
