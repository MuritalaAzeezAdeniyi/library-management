package caverde.task.library.management.repository;

import caverde.task.library.management.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
}
