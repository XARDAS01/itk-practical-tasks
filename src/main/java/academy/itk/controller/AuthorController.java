package academy.itk.controller;

import academy.itk.api.dto.BookDto;
import academy.itk.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/author")
public record AuthorController(AuthorService authorService) {

}
