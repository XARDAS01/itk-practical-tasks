package academy.itk.repository;

import academy.itk.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private static final String SQL_SAVE = "insert into users (id, name, age) values (?, ?, ?)";

    private final JdbcTemplate jdbcTemplate;

    public UUID saveUser(User user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
        }

        jdbcTemplate.update(SQL_SAVE, user.getId(), user.getName(), user.getAge());

        return user.getId();
    }
}
