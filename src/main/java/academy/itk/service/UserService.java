package academy.itk.service;

import academy.itk.api.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserDto> getUsers();

    UserDto getUserById(UUID id);

    void create(UserDto user);

    void update(UserDto user);

    void delete(UUID id);
}
