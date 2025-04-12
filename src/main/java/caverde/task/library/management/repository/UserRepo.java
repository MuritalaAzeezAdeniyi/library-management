package caverde.task.library.management.repository;

import caverde.task.library.management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
   Optional <User> findByEmail(String email);
}
