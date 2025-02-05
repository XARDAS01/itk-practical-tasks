package academy.itk.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/author")
public record AuthorController() {

    @GetMapping
    public ResponseEntity<String> getAuthor() {
        return ResponseEntity.ok().body("Author name");
    }

    @GetMapping("/secure")
    public ResponseEntity<String> getSecureAuthor() {
        return ResponseEntity.ok().body("Secure Author name");
    }
}
