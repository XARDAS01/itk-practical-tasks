package academy.itk.controller;

import academy.itk.api.LoginRequest;
import academy.itk.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public record AuthController(AuthService authService) {

    @PostMapping("/login")
    public ResponseEntity<String> getSecureModerator(@RequestBody LoginRequest loginRequest) {
        SecurityContextHolder.getContext();

        return ResponseEntity.ok().body(authService.login(loginRequest));
    }
}
