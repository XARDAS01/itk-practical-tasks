package academy.itk.service;

import academy.itk.api.LoginRequest;

public interface AuthService {

    String login(LoginRequest loginRequest);
}
