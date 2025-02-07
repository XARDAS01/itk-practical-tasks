package academy.itk.service.impl;

import academy.itk.model.User;
import academy.itk.repository.UserRepository;
import academy.itk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UUID save(User user) {
        return userRepository.saveUser(user);
    }
}
