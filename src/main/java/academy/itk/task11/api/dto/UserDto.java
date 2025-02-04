package academy.itk.task11.api.dto;

import academy.itk.task11.api.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserDto {

    @JsonView(Views.Public.class)
    private UUID id;

    @NotNull(message = "Name cannot be null")
    @JsonView(Views.Public.class)
    private String name;

    @NotNull(message = "Email cannot be null")
    @Email
    @JsonView(Views.Public.class)
    private String email;

    @JsonView(Views.Internal.class)
    private List<OrderDto> orders;
}
