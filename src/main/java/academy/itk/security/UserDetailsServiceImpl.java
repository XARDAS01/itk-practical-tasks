package academy.itk.security;

import academy.itk.enums.UserRole;
import academy.itk.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final List<User> users = List.of(
            new User(
                    UUID.randomUUID(),
                    "user",
                    "$2a$12$9DLrNK9jdic/Piz3HAmIIOFUTZXEKgMpyIQpenNRgCuiF469P9Xc.",
                    "USER",
                    "USER",
                    UserRole.USER,
                    false,
                    false,
                    false
            ),
            new User(
                    UUID.randomUUID(),
                    "moderator",
                    "$2a$12$m20c2.z4kEFCRdRrkm36n.32Jofk5UYmn2xhECsCAiYx0wPugC3h6",
                    "MODERATOR",
                    "MODERATOR",
                    UserRole.MODERATOR,
                    false,
                    false,
                    false
            ),
            new User(
                    UUID.randomUUID(),
                    "admin",
                    "$2a$12$1qGmP9CI/9wFX8Fvp4740eRHZiWH9aoHVOYBGkQEjrDDhzZQzpsdC",
                    "ADMIN",
                    "ADMIN",
                    UserRole.SUPER_ADMIN,
                    false,
                    false,
                    false
            )
    );

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
