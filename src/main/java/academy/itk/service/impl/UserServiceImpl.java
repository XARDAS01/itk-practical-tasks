package academy.itk.service.impl;

import academy.itk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Override
    @PreAuthorize("hasRole('USER')")
    public String getUser(String username) {
        return "Secured user: " + username;
    }

    @Override
    @PreAuthorize("hasRole('MODERATOR')")
    public String getModerator(String username) {
        return "Secured moderator: " + username;
    }

    @Override
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public String getSuperAdmin(String username) {
        return "Secured superadmin: " + username;
    }
}
