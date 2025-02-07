package academy.itk.controller;

import academy.itk.model.User;
import academy.itk.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public record UserController(UserService userService) {

    @PostMapping
    public ResponseEntity<UUID> createUser(User user) {
        return ResponseEntity.ok().body(userService.save(user));
    }
}
