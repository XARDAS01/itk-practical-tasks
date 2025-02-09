package academy.itk.repository;

import academy.itk.model.User;
import academy.itk.projection.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("""
                select new academy.itk.projection.UserProjection(user.name, user.age)
                from User user
                where user.id = :id
            """)
    UserProjection findUserProjectionById(UUID id);
}
