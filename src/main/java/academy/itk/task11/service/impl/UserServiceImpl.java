package academy.itk.task11.service.impl;

import academy.itk.task11.api.dto.UserDto;
import academy.itk.task11.mapper.UserMapper;
import academy.itk.task11.repository.UserRepository;
import academy.itk.task11.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(userMapper::mapToDto).toList();
    }

    @Override
    public UserDto getUserById(UUID id) {
        return userMapper.mapToDto(userRepository.findById(id).orElseThrow());
    }

    @Override
    public void create(UserDto user) {
        userRepository.save(userMapper.mapToEntity(user));
    }

    @Override
    public void update(UserDto user) {
        userRepository.findById(user.getId()).ifPresentOrElse(
                el -> userMapper.update(el, user),
                () -> {
                    throw new UnsupportedOperationException("Error while user update");
                });
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}
