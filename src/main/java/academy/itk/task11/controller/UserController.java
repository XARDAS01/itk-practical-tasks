package academy.itk.task11.controller;

import academy.itk.task11.api.Views;
import academy.itk.task11.api.dto.UserDto;
import academy.itk.task11.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public record UserController(UserService userService) {

    @GetMapping("/all")
    @JsonView(Views.Public.class)
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    @JsonView(Views.Internal.class)
    public UserDto getUsers(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public void createUser(@RequestBody @Valid UserDto userDto) {
        userService.create(userDto);
    }

    @PutMapping
    public void updateUser(@RequestBody @Valid UserDto userDto) {
        userService.update(userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userService.delete(id);
    }
}
