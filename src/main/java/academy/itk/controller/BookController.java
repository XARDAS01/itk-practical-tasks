package academy.itk.controller;

import academy.itk.api.dto.BookDto;
import academy.itk.service.BookService;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/book")
public record BookController(BookService bookService) {

    @PostMapping("/{id}")
    public ResponseEntity<Void> createBook(@PathVariable UUID id, @RequestBody BookDto bookDto) {
        bookService.create(id, bookDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> readBook(@PathVariable UUID id) {
        return ResponseEntity.ok().body(bookService.read(id));
    }

    @GetMapping
    public Page<BookDto> getPage(Pageable pageable) {
        return bookService.readPage(pageable);
    }

    @PutMapping
    public ResponseEntity<Void> updateBook(@RequestBody BookDto bookDto) {
        bookService.update(bookDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable UUID id) {
        bookService.delete(id);
        return ResponseEntity.ok().build();
    }
}
