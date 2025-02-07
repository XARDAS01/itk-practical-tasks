package academy.itk.service;

import academy.itk.model.User;

import java.util.UUID;

public interface UserService {

    UUID save(User user);
}
