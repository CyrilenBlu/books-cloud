package blu.books.recordservice.repositories;

import blu.books.recordservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository()
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String title);
    Optional<Book> findByEan(String uuid);
    List<Book> findAllByShelfNo(String shelfNo);
}
