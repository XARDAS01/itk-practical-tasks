package academy.itk.service.impl;

import academy.itk.api.dto.BookDto;
import academy.itk.mapper.BookMapper;
import academy.itk.repository.AuthorRepository;
import academy.itk.repository.BookRepository;
import academy.itk.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class BookServiceImpl implements BookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public UUID create(UUID id, BookDto bookDto) {
        final var author = authorRepository.findById(id).orElseThrow();
        return bookRepository.save(bookMapper.mapToEntity(bookDto, author)).getId();
    }

    @Override
    public BookDto read(UUID id) {
        return bookRepository.findById(id).map(bookMapper::mapToDto).orElseThrow();
    }

    @Override
    public Page<BookDto> readPage(Pageable pageable) {
        return bookRepository.findAll(pageable).map(bookMapper::mapToDto);
    }

    @Override
    public void update(BookDto bookDto) {
        bookRepository.findById(bookDto.getId()).ifPresent(book ->
                bookMapper.update(book, bookDto));
    }

    @Override
    public void delete(UUID id) {
        bookRepository.deleteById(id);
    }
}
