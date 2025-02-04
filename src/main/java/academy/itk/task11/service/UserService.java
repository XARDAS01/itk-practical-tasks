package academy.itk.task11.service;

import academy.itk.task11.api.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserDto> getUsers();

    UserDto getUserById(UUID id);

    void create(UserDto user);

    void update(UserDto user);

    void delete(UUID id);
}
