package example.hello_security.controller.dto;

public record LoginResponse(String username, long expiresIn) {
}
