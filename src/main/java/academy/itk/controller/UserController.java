package academy.itk.controller;

import academy.itk.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public record UserController(UserService userService) {

    @GetMapping
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok().body("Public User name");
    }

    @PostMapping("/secure/user")
    public ResponseEntity<String> getSecureUser(@RequestBody String name) {
        return ResponseEntity.ok().body(userService.getUser(name));
    }

    @PostMapping("/secure/moderator")
    public ResponseEntity<String> getSecureModerator(@RequestBody String name) {
        return ResponseEntity.ok().body(userService.getModerator(name));
    }

    @PostMapping("/secure/admin")
    public ResponseEntity<String> getSecureAdmin(@RequestBody String name) {
        return ResponseEntity.ok().body(userService.getSuperAdmin(name));
    }
}
