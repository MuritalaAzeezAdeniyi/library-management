package caverde.task.library.management.repository;


import org.apache.tomcat.jni.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Transaction extends JpaRepository<Library, Long> {

}
