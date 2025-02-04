package academy.itk.service;

import academy.itk.api.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface BookService {

    UUID create(UUID id, BookDto bookDto);

    BookDto read(UUID id);

    Page<BookDto> readPage(Pageable pageable);

    void update(BookDto bookDto);

    void delete(UUID id);
}
