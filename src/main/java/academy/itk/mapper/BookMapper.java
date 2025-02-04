package academy.itk.mapper;

import academy.itk.api.dto.BookDto;
import academy.itk.model.Author;
import academy.itk.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto mapToDto(Book source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "source.name")
    @Mapping(target = "author", source = "author")
    Book mapToEntity(BookDto source, Author author);

    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget Book target, BookDto source);
}
