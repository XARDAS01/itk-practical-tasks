package academy.itk.api.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class BookDto {

    private UUID id;
    private String name;
    private UUID author;
}
